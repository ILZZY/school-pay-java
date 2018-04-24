/**   
 * @Title: OauthUrlBO.java 
 * @Package com.zl.sp.model 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zl   
 * @date Apr 17, 2018 1:08:59 PM 
 * @version V1.0  
 */
package com.zl.sp.model;

/** 
 * @ClassName: OauthUrlBO 
 * @Description: 获取授权页面URL所需参数BO 
 * @author zl
 * @date 18-04-17 1:08:59 PM
 */
public class OauthUrlBO {
	/** 
	* @Fields app_id : 开发者应用的app_id
	*/ 
	private String app_id;
	
	/** 
	* @Fields scope : 接口权限值，目前只支持auth_user和auth_base两个值
	*/ 
	private String scope;
	
	/** 
	* @Fields redirect_uri : 回调页面，是 经过转义 的url链接（url必须以http或者https开头），比如：http%3A%2F%2Fexample.com
	*                        在请求之前，开发者需要先到开发者中心对应应用内，配置授权回调地址。
	*/ 
	private String redirect_uri;
	
	/** 
	* @Fields state : 商户自定义参数，用户授权后，重定向到redirect_uri时会原样回传给商户。 为防止CSRF攻击，建议开发者请求授权时传入state参数，该参数要做到既不可预测，又可以证明客户端和当前第三方网站的登录认证状态存在关联。 
	*/ 
	private String state;

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getRedirect_uri() {
		return redirect_uri;
	}

	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
