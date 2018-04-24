package com.zl.sp.common;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
	/** 
	* @Fields app_id : 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号 
	*/ 
	public static String app_id = "2016091500519793"; 
	
    /** 
    * @Fields merchant_private_key : 商户私钥，您的PKCS8格式RSA2私钥 
    */ 
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCaoaIP0MdKHVoU/Q/q6D60d60R2kAN1UIH76iG3pqwnGgLXTR5d+pq4K0Rpc2nLr2gdWrK0wx4yWa04Zvz3fn++BsLdjCAi45pSBuMEqXOyi64LZFZaXmosk+1tZiWXxxtBtHd2Xor42VRXDowNxeGJbFohmm/Kjm4HcTCXWhaJoeNlbjt3LD+fBQzEvYN+tkrVJyyY+uRMQYlkJiqfIAnBoYcokoTNUnlASJ9BJQiJwYhg/HGng1PfgRubVV01rzjq+TRpeWTHQsACkD3iNDIVpKiVa96CE8TEsuVn4m41xK5StAyuYEGcQLw7ifJ//m4/ZN94c07bpK4XdDdnC8fAgMBAAECggEAUca3MUwFiSGauUzX9TBbsQ81fSKCC47Du/S3mJPzFQGyWIgzLyYG1/z4KkQYTZj/efN+xcL1bo98fJ5v3nl/M6M8kkQwBFtJtk4HG33lKEZujMK0gqewSlH6q6tdBfFI1DPuGzhfTwSUWYG/2C3ah/w5JYEoPYv0OHWtz+icPkgYPJWRTOcAX1NhG9ck8oC+/NKdfIEcfoRDPG6ubHq1/+iYiEM7oyPCtr5YuU6a84lW1wgyXUG/5IBW8R1t0jtc/9AKEkcpLmi4jy03JG6nVPdRSbMBVhRqMQItXmmu/24Spn9vur2NWbGSfNnjJf5WvG+14OJVOKyQwgsK5/CBUQKBgQD5iktw04pKA74o7qHaTTz0jQ46SD3cZ3jLwRpOhklgVQi9xUyOzuEvIxw1mhDtO8cuZTDnXFAf/7Fi7o+QFbT0WZD/ZkIdPyx9KQDN3LSyuU/nr2hcqwN1Im3X1AxpkMxhbn+sUy2DYkfd8Icv+TFUd5OdNFqP6kG1Yt4DdVhtaQKBgQCeomBrSZWSHsBtWE8Ypz1D6VRdQ/rA8B23jBrMFiSGiUi6Q5X2i9MRXaIChf5O82bOH5aA9hDwCQ88nV8iXA7UGuPY6YfJf4MJ04mZQ8eKViachgHbYx111qRbxbfPYSqfackbc5wIddWxf+poBWLlnRLvWN4yccmAZzDWG8E/RwKBgBEN6ZABdR8P2Gw1uuwPgU35YfKLw2aPz8qlHOYm+VbTGPDXTh8odm1hSelD6Uo9XqSGF+yH+5XkRLxNL5SaVy6n/GfoFjanfaPkLIDlR5g7YAGmlExZB7h2rOkmPd7tHXq/MYyWdrLXAbBiYurdbgimz3jb/iB90xXRdvjniS6ZAoGAVTIFsHkTgCdN1yvPRwFCcP+WFITW3dnXS+VN2v+lXC/MxGRZ3NBZagEsakiGPOaR9u+WB+qfTBrBeR9XoX9pY1aRucQp7fiyaouWYZ66Qrxj/jomMyn2/3toR/VW82RO3NCWdkzPpueJ/csiG/2QkJqcObkzlEnyGyjQXJ0JWy8CgYEA1hCgzkFhnSSGj0AjUPAzxaIoGXIgw0Bp9yFQGiJhY9jWQ/TI2By8C+AF47pFsvAm3VUDRKRQIbqRYNaj9P2Wsa0mBeCi+krc36B11A3EtBcGqLHkLLdzWPZRJIjAAUiinn3Bqma7Jtb95cAtp5TX02Bd/wbg3P/DjC66PDoSmJ8=";
	
    /** 
    * @Fields alipay_public_key : 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    */ 
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1/ZKS/DifP1wsy2FeXc6UF22bh2R7rKRGBfq9eQASZMeb2qRZ9D9yGHWOS7W0xe/mmLyvKAR0eeNtX4RJuiJk4QW6/CVWfGDJmQ+0DlgXD2+6sgV38sU2010tFLbp07VdCEgnngUX2lidWE1LGf30Yn5UWEP2REg6AHc/JUPsCC1j5YpGG0nUfKTAt2mxsXmZhhrRYaSByr4uoIhCQgzV+Id+kGusHN6vMY6W4ghNjlL/tWK+SuwPg0/JB+4L3X+/xmnRePvHSLGsbD1eMpd5hRY3Mf5yK3UfjHdB/WPsaHovg5fv0fw0j7ZYy6oiZAfGjYI6i6H7Tuy01UB167KqQIDAQAB";

    /** 
    * @Fields notify_url : 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    */ 
    public static String notify_url = "http://222.210.112.159:8080/school-pay-java/zl_alipay/_alipayNotify";

	/** 
	* @Fields return_url : 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 
	*/ 
	public static String return_url = "http://localhost:3001/pay/return_url";
	
	/** 
	* @Fields return_url : 回调页面，是经过转义 的url链接（url必须以http或者https开头），比如：http%3A%2F%2Fexample.com
	*                      在请求之前，开发者需要先到开发者中心对应应用内，配置授权回调地址。 
	*/ 
	public static String redirect_uri = "http://220.167.45.213:3001/pay/redirect_uri";

	/** 
	* @Fields sign_type : 签名方式
	*/ 
	public static String sign_type = "RSA2";
	
	/** 
	* @Fields charset : 字符编码格式 
	*/ 
	public static String charset = "utf-8";
	
	/** 
	* @Fields gatewayUrl : 支付宝网关 
	*/ 
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	/** 
	* @Fields log_path : 支付宝网关 
	*/ 
	public static String log_path = "H:\\";
	
	/** 
	* @Fields format : 格式 
	*/ 
	public static String format = "json";
	
	/** 
	* @Fields scope : 接口权限值，目前只支持auth_user和auth_base两个值
	*/ 
	public static String scope = "auth_user,auth_base";
	
	/** 
	* @Fields state : 商户自定义参数，用户授权后，重定向到redirect_uri时会原样回传给商户。 为防止CSRF攻击，建议开发者请求授权时传入state参数，该参数要做到既不可预测，又可以证明客户端和当前第三方网站的登录认证状态存在关联。 
	*/ 
	public static String state;


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

