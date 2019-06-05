/**
 * 
 */
package com.duoduo.security.browser.handler;

import com.duoduo.security.core.enums.LoginResponseType;
import com.duoduo.security.core.properties.BrowserProperties;
import com.duoduo.security.core.response.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 浏览器环境下登录失败的处理器
 * 
 * @author zhailiang
 *
 */
public class BrowserAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {


	private ObjectMapper objectMapper = new ObjectMapper();

	private BrowserProperties browserProperties;

	public BrowserAuthenctiationFailureHandler(BrowserProperties browserProperties){
		this.browserProperties = browserProperties;
	}

	/**
	 * @desc 失败处理逻辑
	 * @param request
	 * @param response
	 * @param exception
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
		
		if (LoginResponseType.JSON.equals(browserProperties.getSignInResponseType())) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString(Result.build(HttpStatus.UNAUTHORIZED.value(),Result.MSG_FAIL,exception.getMessage())));
		}else{
			super.onAuthenticationFailure(request, response, exception);
		}
		
	}
}
