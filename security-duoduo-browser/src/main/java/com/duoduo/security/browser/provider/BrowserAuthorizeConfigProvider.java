/**
 * 
 */
package com.duoduo.security.browser.provider;

import com.duoduo.security.core.properties.BrowserProperties;
import com.duoduo.security.core.provider.AuthorizeConfigProvider;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 浏览器环境默认的授权配置，对常见的静态资源，如js,css，图片等不验证身份
 * 
 * @author zhailiang
 *
 */
public class BrowserAuthorizeConfigProvider implements AuthorizeConfigProvider {

	private BrowserProperties browserProperties;


	/**
	 * @desc 不校验的静态资源
	 * @param config
	 * @return
	 */
	@Override
	public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		List<String> excludeResources = browserProperties.getExcludeResources();
		if(!CollectionUtils.isEmpty(excludeResources)){
			config.antMatchers(HttpMethod.GET,
					excludeResources.toArray(new String[excludeResources.size()])).permitAll();
		}

		return false;
	}

}
