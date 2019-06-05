/**
 * 
 */
package com.duoduo.security.core.constants;

/**
 * @desc 默认配置
 * @author zhailiang
 *
 */
public interface SecurityConstants {

	/**
	 * 浏览器后缀
	 */
	String BROWSER_SUFFIX = ".html";

	/**
	 * 提示登陆成功提示语
	 */
	String DEFAULT_LOGIN_SUCCESS_MSG = "登陆成功";

	/**
	 * 提示退出成功提示语
	 */
	String DEFAULT_LOGOUT_SUCCESS_MSG = "退出成功";
	/**
	 * 默认的处理验证码的url前缀
	 */
	String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
	/**
	 * 当请求需要身份认证时，默认跳转的url
	 * 
	 */
	String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
	/**
	 * 默认的用户名密码登录请求处理url
	 */
	String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/authentication/form";
	/**
	 * 默认的手机验证码登录请求处理url
	 */
	String DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE = "/authentication/mobile";
	/**
	 * 默认的OPENID登录请求处理url
	 */
	String DEFAULT_SIGN_IN_PROCESSING_URL_OPENID = "/authentication/openid";
	/**
	 * 默认登录页面
	 * 
	 */
	String DEFAULT_SIGN_IN_PAGE_URL = "/duoduo-signIn.html";
	/**
	 * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
	 */
	String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
	/**
	 * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
	 */
	String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
	/**
	 * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
	 */
	String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
	/**
	 * openid参数名
	 */
	String DEFAULT_PARAMETER_NAME_OPENID = "openId";
	/**
	 * providerId参数名
	 */
	String DEFAULT_PARAMETER_NAME_PROVIDERID = "providerId";
	/**
	 * session失效默认的跳转地址
	 */
	String DEFAULT_SESSION_INVALID_URL = "/duoduo-session-invalid.html";
	/**
	 * 获取第三方用户信息的url
	 */
	String DEFAULT_SOCIAL_USER_INFO_URL = "/social/user";

	String DEFAULE_SOCIAL_SIGNUPURL = "/duoduo-signUp.html";

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";
}
