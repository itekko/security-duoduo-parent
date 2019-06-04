/**
 * 
 */
package com.duoduo.security.browser.session;

import com.duoduo.security.core.properties.BrowserProperties;
import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 默认的session失效处理策略
 * 
 * @author zhailiang
 *
 */
public class ImoocInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {

	public ImoocInvalidSessionStrategy(BrowserProperties browserProperties) {
		super(browserProperties);
	}

	@Override
	public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		onSessionInvalid(request, response);
	}

}
