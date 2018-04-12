/**   
 * @Title: WebKit.java 
 * @Package com.zl.sp.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zl   
 * @date Apr 5, 2018 6:20:39 PM 
 * @version V1.0  
 */
package com.zl.sp.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @ClassName: WebKit
 * @Description: TODO
 * @author zl
 * @date 18-04-05 6:20:39 PM
 */
public class WebKit {

	/**
	 * @Title: getRequest @date 18-04-05 6:21:04 PM @Description:
	 *         TODO @param @return @return HttpServletResponse @throws
	 */
	public static HttpServletRequest getRequest() {

		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = null;
		if (null != requestAttributes) {
			request = ((ServletRequestAttributes) requestAttributes).getRequest();
		} else {
			return null;
		}

		return request;
	}

	/** 
	 * @Title: getResponse 
	 * @date 18-04-05 6:28:17 PM
	 * @Description: TODO 
	 * @param @return
	 * @return HttpServletResponse
	 * @throws  
	 */
	public static HttpServletResponse getResponse() {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		return response;
	}
}
