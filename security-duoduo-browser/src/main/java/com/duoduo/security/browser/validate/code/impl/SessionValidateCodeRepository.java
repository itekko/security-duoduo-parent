/**
 * 
 */
package com.duoduo.security.browser.validate.code.impl;


import com.duoduo.security.core.code.repository.ValidateCodeRepository;
import com.duoduo.security.core.constants.SecurityConstants;
import com.duoduo.security.core.enums.ValidateCodeType;
import com.duoduo.security.core.model.code.ValidateCode;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.RequestAttributes;

/**
 * 基于session的验证码存取器
 * 
 * @author zhailiang
 *
 */
public class SessionValidateCodeRepository implements ValidateCodeRepository {

	/**
	 * 验证码放入session时的前缀
	 */
	String SESSION_KEY_PREFIX = SecurityConstants.SESSION_KEY_PREFIX;
	
	/**
	 * 操作session的工具类
	 */
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

	/* (non-Javadoc)
	 * @see com.duoduo.security.core.validate.code.ValidateCodeRepository#save(org.springframework.web.context.request.ServletWebRequest, com.duoduo.security.core.validate.code.ValidateCode, com.duoduo.security.core.validate.code.ValidateCodeType)
	 */
	@Override
	public void save(RequestAttributes request, ValidateCode code, ValidateCodeType validateCodeType) {
		sessionStrategy.setAttribute(request, getSessionKey(request, validateCodeType), code);
	}
	
	/**
	 * 构建验证码放入session时的key
	 * 
	 * @param request
	 * @return
	 */
	private String getSessionKey(RequestAttributes request, ValidateCodeType validateCodeType) {
		return SESSION_KEY_PREFIX + validateCodeType.toString().toUpperCase();
	}

	/* (non-Javadoc)
	 * @see com.duoduo.security.core.validate.code.ValidateCodeRepository#get(org.springframework.web.context.request.ServletWebRequest, com.duoduo.security.core.validate.code.ValidateCodeType)
	 */
	@Override
	public ValidateCode get(RequestAttributes request, ValidateCodeType validateCodeType) {
		return (ValidateCode) sessionStrategy.getAttribute(request, getSessionKey(request, validateCodeType));
	}

	/* (non-Javadoc)
	 * @see com.duoduo.security.core.validate.code.ValidateCodeRepository#remove(org.springframework.web.context.request.ServletWebRequest, com.duoduo.security.core.validate.code.ValidateCodeType)
	 */
	@Override
	public void remove(RequestAttributes request, ValidateCodeType codeType) {
		sessionStrategy.removeAttribute(request, getSessionKey(request, codeType));
	}

}
