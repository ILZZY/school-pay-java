/**   
 * @Title: Tip.java 
 * @Package com.zl.sp.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zl   
 * @date Mar 29, 2018 9:09:52 PM 
 * @version V1.0  
 */
package com.zl.sp.common;

/**
 * @ClassName: Tip
 * @Description: TODO
 * @author zl
 * @date 18-03-29 9:09:52 PM
 */
public class Tip {
	protected String msg_;
	protected Object data;
	protected int code_;

	/** 
	* <p>构造函数: Tip</p> 
	* <p>Description: </p> 
	* @param errorCode
	* @param codeMsg 
	*/
	public Tip(int code, String codeMsg) {
		this.code_ = code;
		this.msg_ = codeMsg;
	}

	/** 
	* <p>构造函数: Tip</p> 
	* <p>Description: </p>  
	*/
	public Tip() {
		// TODO 自动生成的构造函数存根
	}

	public String getMsg_() {
		return msg_;
	}

	public void setMsg_(String msg_) {
		this.msg_ = msg_;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCode_() {
		return code_;
	}

	public void setCode_(int code_) {
		this.code_ = code_;
	}
}
