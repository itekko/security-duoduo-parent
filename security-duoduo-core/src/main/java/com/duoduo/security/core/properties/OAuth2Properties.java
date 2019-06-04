/**
 * 
 */
package com.duoduo.security.core.properties;

import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;

/**
 * @author zhailiang
 *
 */
public class OAuth2Properties {
	
	/**
	 * 使用jwt时为token签名的秘钥
	 */
	private String jwtSigningKey = "duoduo";
	/**
	 * 客户端配置
	 */
	private OAuth2ClientProperties[] clients = {};

	public OAuth2ClientProperties[] getClients() {
		return clients;
	}

	public void setClients(OAuth2ClientProperties[] clients) {
		this.clients = clients;
	}

	public String getJwtSigningKey() {
		return jwtSigningKey;
	}

	public void setJwtSigningKey(String jwtSigningKey) {
		this.jwtSigningKey = jwtSigningKey;
	}
	
}
