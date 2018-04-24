/**   
 * @Title: NotifyBO.java 
 * @Package com.zl.sp.model 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zl   
 * @date Apr 23, 2018 11:50:21 PM 
 * @version V1.0  
 */
package com.zl.sp.model;

import java.util.Date;

/** 
 * @ClassName: NotifyBO 
 * @Description: TODO 
 * @author zl
 * @date 18-04-23 11:50:21 PM
 */
public class NotifyBO {
	private Date notify_time;
	private String trade_status;
	
	public Date getNotify_time() {
		return notify_time;
	}
	public void setNotify_time(Date notify_time) {
		this.notify_time = notify_time;
	}
	public String getTrade_status() {
		return trade_status;
	}
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
	
	
}
