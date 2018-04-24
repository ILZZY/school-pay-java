/**   
 * @Title: AlipayController.java 
 * @Package com.zl.sp.web.controller 
 * @Description:(用一句话描述该文件做什么) 
 * @author zl   
 * @date Apr 16, 2018 1:05:35 PM 
 * @version V1.0  
 */
package com.zl.sp.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.wordnik.swagger.annotations.Api;
import com.zl.sp.common.AlipayConfig;
import com.zl.sp.common.BaseController;
import com.zl.sp.common.Tip;
import com.zl.sp.model.OauthUrlBO;
import com.zl.sp.model.PayBO;
import com.zl.sp.persistence.entity.Order;
import com.zl.sp.service.IOrderService;
import com.zl.sp.utils.SpTools;

/**
 * @ClassName: AlipayController
 * @Description: 
 * @author zl
 * @date 18-04-16 1:05:35 PM
 */
@Api(value = "/zl_alipay")
@RestController
@RequestMapping("/zl_alipay")
public class AlipayController extends BaseController {
	@Autowired
    IOrderService orderService;
	
	@PostMapping(value = "/_pay", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Tip pay(@RequestBody PayBO param) {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(
				AlipayConfig.gatewayUrl,
				AlipayConfig.app_id,
				AlipayConfig.merchant_private_key,
				AlipayConfig.format,
				AlipayConfig.charset,
				AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		
		//业务请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递，具体参照各产品快速接入文档
		String bizContent = "{\"out_trade_no\":\""+ param.getOut_trade_no() +"\"," 
				+ "\"total_amount\":\""+ param.getTotal_amount() +"\"," 
				+ "\"subject\":\""+ param.getSubject() +"\"," 
				+ "\"body\":\""+ param.getBody() +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}";
		
		//若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
		//alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
		//		+ "\"total_amount\":\""+ total_amount +"\"," 
		//		+ "\"subject\":\""+ subject +"\"," 
		//		+ "\"body\":\""+ body +"\"," 
		//		+ "\"timeout_express\":\"10m\"," 
		//		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		//请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
		
		alipayRequest.setBizContent(bizContent);
		String result = "请求出现异常";
		try {
			//订单入库
			Order entity = new Order();
			entity.setOrderOutTradeNo(param.getOut_trade_no());
			entity.setOrderUserName(param.getOrderUserName());
			entity.setOderSubject(param.getSubject());
			entity.setOrderAmount(param.getTotal_amount());
			entity.setOrderStatus(0);
			entity.setOrderGenerateTime(new Date());
			orderService.insert(entity);
			//请求
			result = alipayClient.pageExecute(alipayRequest).getBody();
			return succes(result);
		} catch (AlipayApiException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return fail(result);
		}
	}
	
	@PostMapping(value = "/_oauthurl", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Tip oauthUrl(@RequestBody OauthUrlBO param){
		OauthUrlBO oauthUrl = new OauthUrlBO();
		oauthUrl.setApp_id(AlipayConfig.app_id);
		oauthUrl.setRedirect_uri(AlipayConfig.redirect_uri);
		oauthUrl.setScope(AlipayConfig.scope);
		oauthUrl.setState(AlipayConfig.state);
		if(null != param.getApp_id()) {
			oauthUrl.setApp_id(param.getApp_id());
		}
		if(null != param.getRedirect_uri()) {
			oauthUrl.setRedirect_uri(param.getRedirect_uri());
		}
		if(null != param.getScope()) {
			oauthUrl.setScope(param.getScope());
		}
		if(null != param.getState()) {
			oauthUrl.setState(param.getState());
		}
		String encodeRUrl = "";
		try {
			encodeRUrl = URLEncoder.encode(oauthUrl.getRedirect_uri(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// 自动生成的 catch 块
			System.out.println(e.getMessage());
			e.printStackTrace();
			return fail("回掉地址转码错误！");
		}
		
		String url = "https://openauth.alipaydev.com/oauth2/publicAppAuthorize.htm"
				+ "?app_id=" + oauthUrl.getApp_id()
				+ "&scope=" + oauthUrl.getScope()
				+ "&redirect_uri=" + encodeRUrl;
		if(null != param.getState()) {
			url = url + "&state=" + oauthUrl.getState();
		}
		return succes(url);
	}

	@PostMapping(value = "/_oauthtoken/{authCode}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Tip oauthToken(@PathVariable String authCode) {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(
				AlipayConfig.gatewayUrl,
				AlipayConfig.app_id,
				AlipayConfig.merchant_private_key,
				AlipayConfig.format,
				AlipayConfig.charset,
				AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		
		//设置请求参数
		AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
		request.setCode(authCode);
		request.setGrantType("authorization_code");
		String result = "请求出现异常";
		try {
			//请求
			AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request);
		    result = oauthTokenResponse.getAccessToken();
			return succes(result);
		} catch (AlipayApiException e) {
			//  自动生成的 catch 块
			System.out.println(e.getMessage());
			e.printStackTrace();
			return fail(result);
		}
	}

	@PostMapping(value = "/_oauthinfo/{token}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Tip oauthInfo(@PathVariable String token) {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(
				AlipayConfig.gatewayUrl,
				AlipayConfig.app_id,
				AlipayConfig.merchant_private_key,
				AlipayConfig.format,
				AlipayConfig.charset,
				AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
		String auth_token = token;
		String result = "请求出现异常";
		try {
			//请求
			AlipayUserInfoShareResponse userinfoShareResponse = alipayClient.execute(request, auth_token);
		    result = userinfoShareResponse.getBody();
			return succes(result);
		} catch (AlipayApiException e) {
			//  自动生成的 catch 块
			System.out.println(e.getMessage());
			e.printStackTrace();
			return fail(result);
		}
	}

	@RequestMapping(value="/_alipayNotify")
	public void alipayNotif(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//获取支付宝POST过来反馈信息
		response.setHeader("content-type", "text/html;charset=UTF-8");
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}
		boolean signVerified = false;
		//调用SDK验证签名
		try {
			signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
		} catch (AlipayApiException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		if(signVerified) {//验证成功
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
			
			System.out.println(out_trade_no+":"+trade_status);
			
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
					
				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			}else if (trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				
				//注意：
				//付款完成后，支付宝系统发送该交易状态通知
				Order entity = new Order();
				entity.setOrderOutTradeNo(out_trade_no);
				Wrapper<Order> wrapper = SpTools.createEntityWrapper(entity);
				entity = orderService.selectOne(wrapper);
				if(SpTools.isNotEmpty(entity)) {					
					entity.setOrderStatus(1);
					orderService.updateById(entity);
					System.out.println("订单状态更新成功！");
				}
			}
			response.getWriter().print("success");
			//out.println("success");
		}else {//验证失败
			response.getWriter().print("fail");
			//out.println("fail");
			
			//调试用，写文本函数记录程序运行情况是否正常
			//String sWord = AlipaySignature.getSignCheckContentV1(params);
			//AlipayConfig.logResult(sWord);
		}		
	}	

}
