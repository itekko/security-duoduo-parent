/**
 * 
 */
package com.duoduo.security.browser.logout;

import com.duoduo.security.core.constants.SecurityConstants;
import com.duoduo.security.core.properties.BrowserProperties;
import com.duoduo.security.core.response.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 默认的退出成功处理器，如果设置了duoduo.security.browser.signOutUrl，则跳到配置的地址上，
 * 如果没配置，则返回json格式的响应。
 * 
 * @author zhailiang
 *
 */
public class BrowserLogoutSuccessHandler implements LogoutSuccessHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private BrowserProperties browserProperties;
	
	private ObjectMapper objectMapper;

	/**
	 * @desc 退出逻辑
	 * @param request
	 * @param response
	 * @param authentication
	 * @throws IOException
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {

		logger.info("{}退出成功",authentication.getPrincipal().toString());

		if (StringUtils.isBlank(browserProperties.getSignOutUrl())) {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString(Result.build(Result.CODE_SUCCESS, SecurityConstants.DEFAULT_LOGOUT_SUCCESS_MSG)));
		} else {
			response.sendRedirect(browserProperties.getSignOutUrl());
		}

	}

}
