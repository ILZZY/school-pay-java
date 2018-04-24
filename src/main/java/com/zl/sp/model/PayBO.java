/**   
 * @Title: Pay.java 
 * @Package com.zl.sp.model 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zl   
 * @date Apr 16, 2018 1:11:38 PM 
 * @version V1.0  
 */
package com.zl.sp.model;

/**
 * @ClassName: Pay
 * @Description: TODO
 * @author zl
 * @date 18-04-16 1:11:38 PM
 */
public class PayBO {
	// 商户订单号，商户网站订单系统中唯一订单号，必填
	private String out_trade_no;
	// 付款金额，必填
	private String total_amount;
	// 订单名称，必填
	private String subject;
	// 商品描述，可空
	private String body;
	// 下单用户
	private String orderUserName;
	
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getOrderUserName() {
		return orderUserName;
	}
	public void setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
	}

	
}
