/**   
 * @Title: BaseController.java 
 * @Package com.zl.sp.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zl   
 * @date Mar 29, 2018 9:22:12 PM 
 * @version V1.0  
 */
package com.zl.sp.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.baomidou.mybatisplus.plugins.Page;
import com.zl.sp.utils.SpTools;

/**
 * @ClassName: BaseController
 * @Description: TODO
 * @author zl
 * @date 18-03-29 9:22:12 PM
 */
public abstract class BaseController {
	protected static String SUCCESS = "SUCCESS_TIP";
	protected static String ERROR = "ERROR_TIP";
	protected static String REDIRECT = "redirect:";
	protected static String FORWARD = "forward:";

	public Tip succes(String msg) {
		return this.succes(msg, null);
	}

	public <T> Tip succes(String msg, T data) {
		Tip tip = new Tip();
		tip.setData(data);
		if (StringUtils.isNotBlank(msg)) {
			tip.setMsg_(msg);
		}
		this.setJsonResponse();
		return tip;
	}
	
	/** 
	 * @Title: setJsonResponse 
	 * @date 18-04-05 6:15:15 PM
	 * @Description: TODO 
	 * @param 
	 * @return void
	 * @throws  
	 */
	private void setJsonResponse() {
		HttpServletResponse response = this.getHttpServletResponse();
		if (SpTools.isNotEmpty(response)) {
			response.setStatus(HttpStatus.OK.value());
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		}
	}

	/** 
	 * @Title: getHttpServletResponse 
	 * @date 18-04-05 6:27:35 PM
	 * @Description: TODO 
	 * @param @return
	 * @return HttpServletResponse
	 * @throws  
	 */
	protected HttpServletResponse getHttpServletResponse() {
		return WebKit.getResponse();
	}

	/** 
	 * @Title: getHttpServletResponse 
	 * @date 18-04-05 6:16:57 PM
	 * @Description: TODO 
	 * @param @return
	 * @return HttpServletResponse
	 * @throws  
	 */
	protected HttpServletRequest getHttpServletRequest() {
		return WebKit.getRequest();
	}

	/**
	 * 根据前端不同的grid组件适配不同的数据分页对象
	 * 
	 * @param page
	 *            持久层返回的翻页数据
	 * @param data
	 *            业务层BO数据
	 * @return
	 */
	protected <ENTY, BO> DataGridInfo packForDataGrid(Page<ENTY> page, List<BO> data) {
		// 默认datatables 表格组件
		return new DataTablesGridInfo(page, data);
	}

	/** 
	 * @Title: succes 
	 * @date 18-03-29 10:10:10 PM
	 * @Description: TODO 
	 * @param @return
	 * @return Object
	 * @throws  
	 */
	public Tip succes() {
		// TODO 自动生成的方法存根
		return this.succes(null, null);
	}
	
	/**
	 * <p>
	 * 操作成功并返回数据
	 * </p>
	 * 
	 * @param msg
	 * @return
	 */
	public <T> Tip succes(T data) {
		return this.succes(null, data);
	}
	
	/**
	 * @author zhangliang
	 * @date 2017年8月21日下午11:31:04
	 * @param msg
	 * @return
	 */
	public Tip fail(String msg) {
		return this.fail(CommonMessage.BUSINESS_ERROR, msg, null);
	}

	public Tip fail(int errorCode, String msg) {
		return this.fail(errorCode, msg, null);
	}

	public <T> Tip fail(String msg, T data) {
		return this.fail(CommonMessage.BUSINESS_ERROR, msg, data);
	}
	
	public <T> Tip fail(int errorCode, String msg, T data) {

		String codeMsg = msg;
		if (500 != errorCode) {
			// 如果msg为空，重置返回默认消息为错误码
			String defMsg = (StringUtils.isBlank(msg) ? Integer.toString(errorCode) : msg);
			codeMsg = defMsg;
		}

		Tip tip = new Tip(errorCode, codeMsg);
		tip.setData(data);
		this.setJsonResponse();
		return tip;
	}
}
