package com.duoduo.security.browser.handler;

import com.duoduo.security.core.constants.SecurityConstants;
import com.duoduo.security.core.enums.LoginResponseType;
import com.duoduo.security.core.properties.BrowserProperties;
import com.duoduo.security.core.response.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 浏览器环境下登录成功的处理器
 * 
 * @author zhailiang
 */
public class BrowserAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private ObjectMapper objectMapper = new ObjectMapper();

	private BrowserProperties browserProperties;

	private RequestCache requestCache = new HttpSessionRequestCache();

	public BrowserAuthenticationSuccessHandler(BrowserProperties browserProperties) {
		this.browserProperties = browserProperties;
	}

	/**
	 * @desc 登陆成功逻辑
	 * @param request
	 * @param response
	 * @param authentication
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

		logger.info("{}登录成功",authentication.getPrincipal().toString());

		if (LoginResponseType.JSON.equals(browserProperties.getSignInResponseType())) {
			response.setContentType("application/json;charset=UTF-8");
			String type = authentication.getClass().getSimpleName();
			response.getWriter().write(objectMapper.writeValueAsString(Result.build(Result.CODE_SUCCESS, SecurityConstants.DEFAULT_LOGIN_SUCCESS_MSG)));
		} else {
			// 如果设置了imooc.security.browser.singInSuccessUrl，总是跳到设置的地址上
			// 如果没设置，则尝试跳转到登录之前访问的地址上，如果登录前访问地址为空，则跳到网站根路径上
			if (StringUtils.isNotBlank(browserProperties.getSingInSuccessUrl())) {
				requestCache.removeRequest(request, response);
				setAlwaysUseDefaultTargetUrl(true);
				setDefaultTargetUrl(browserProperties.getSingInSuccessUrl());
			}
			super.onAuthenticationSuccess(request, response, authentication);
		}

	}

}
