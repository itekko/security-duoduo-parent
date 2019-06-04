/**
 * 
 */
package com.duoduo.security.core.code.repository;

import com.duoduo.security.core.enums.ValidateCodeType;
import com.duoduo.security.core.model.code.ValidateCode;
import org.springframework.web.context.request.RequestAttributes;

/**
 * 校验码存取器
 * 
 * @author zhailiang
 *
 */
public interface ValidateCodeRepository {

	/**
	 * 保存验证码
	 * @param request
	 * @param code
	 * @param validateCodeType
	 */
	void save(RequestAttributes request, ValidateCode code, ValidateCodeType validateCodeType);
	/**
	 * 获取验证码
	 * @param request
	 * @param validateCodeType
	 * @return
	 */
	ValidateCode get(RequestAttributes request, ValidateCodeType validateCodeType);
	/**
	 * 移除验证码
	 * @param request
	 * @param codeType
	 */
	void remove(RequestAttributes request, ValidateCodeType codeType);

}
