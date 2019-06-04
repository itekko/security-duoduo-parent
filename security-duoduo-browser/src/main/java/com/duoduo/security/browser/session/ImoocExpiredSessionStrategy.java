/**
 * 
 */
package com.duoduo.security.browser.session;

import com.duoduo.security.core.properties.BrowserProperties;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import java.io.IOException;

/**
 * 并发登录导致session失效时，默认的处理策略
 * 
 * @author zhailiang
 *
 */
public class ImoocExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

	public ImoocExpiredSessionStrategy(BrowserProperties browserProperties) {
		super(browserProperties);
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.web.session.SessionInformationExpiredStrategy#onExpiredSessionDetected(org.springframework.security.web.session.SessionInformationExpiredEvent)
	 */
	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException{
		onSessionInvalid(event.getRequest(), event.getResponse());
	}
	
	/* (non-Javadoc)
	 * @see com.imooc.security.browser.session.AbstractSessionStrategy#isConcurrency()
	 */
	@Override
	protected boolean isConcurrency() {
		return true;
	}

}
