/**
 * 
 */
package com.duoduo.security.browser.config;


import com.duoduo.security.browser.handler.BrowserAuthenctiationFailureHandler;
import com.duoduo.security.browser.handler.BrowserAuthenticationSuccessHandler;
import com.duoduo.security.core.config.FormAuthenticationConfig;
import com.duoduo.security.core.constants.SecurityConstants;
import com.duoduo.security.core.properties.BrowserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 浏览器环境下自动配置类
 * 
 * @author zhailiang
 *
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(BrowserProperties.class)
@ComponentScan("com.duoduo.security.browser.controller")
public class BrowserSecurityAutoConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BrowserProperties browserProperties;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 自定义表单登陆
		formAuthenticationConfig().configure(http);
		http
			.authorizeRequests()
			.antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,browserProperties.getSignInPage())
			.permitAll()
			.anyRequest()
			.authenticated();
		if(browserProperties.getCsrfDisable()){
			http.csrf().disable();
		}

	}

	@Bean
	@ConditionalOnMissingBean(FormAuthenticationConfig.class)
	public FormAuthenticationConfig formAuthenticationConfig(){
		return new FormAuthenticationConfig(authenticationSuccessHandler(),authenctiationFailureHandler());
	}


	/**
	 * 成功处理器
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(AuthenticationSuccessHandler.class)
	public AuthenticationSuccessHandler authenticationSuccessHandler(){
		return new BrowserAuthenticationSuccessHandler(browserProperties);
	}

	/**
	 * 失败处理器
	 * @return
	 */
	@Bean
	@ConditionalOnBean(AuthenticationSuccessHandler.class)
	public AuthenticationFailureHandler authenctiationFailureHandler(){
		return new BrowserAuthenctiationFailureHandler(browserProperties);
	}







	
}
