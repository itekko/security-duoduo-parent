package com.duoduo.security.core.config;

import com.duoduo.security.core.constants.SecurityConstants;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 表单登录配置
 * 
 * @author zhailiang
 */
public class FormAuthenticationConfig {

	protected AuthenticationSuccessHandler authenticationSuccessHandler;

	protected AuthenticationFailureHandler authenticationFailureHandler;

	public FormAuthenticationConfig(AuthenticationSuccessHandler authenticationSuccessHandler, AuthenticationFailureHandler authenticationFailureHandler) {
		this.authenticationSuccessHandler = authenticationSuccessHandler;
		this.authenticationFailureHandler = authenticationFailureHandler;
	}

	public void configure(HttpSecurity http) throws Exception {
		http.formLogin() // 设置表单登陆
			.loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL) // 设置登陆页面
			.loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM) //表单登陆请求地址
			.successHandler(authenticationSuccessHandler) // 登陆成功以后处理器
			.failureHandler(authenticationFailureHandler); // 登陆失败以后处理器
	}

}
