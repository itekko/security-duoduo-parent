package com.duoduo.security.autoconfigure;

import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @desc 配置类
 * @author lixiaolong
 * @create 2019-06-04 10:34
 */
@ConfigurationProperties(prefix = "duoduo.security")
public class SecurityDuoduoProperties {

    /**
     * 浏览器环境配置
     */
    private BrowserProperties browser = new BrowserProperties();
    /**
     * 验证码配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();
    /**
     * 社交登录配置
     */
    private SocialProperties social = new SocialProperties();
    /**
     * OAuth2认证服务器配置
     */
    private OAuth2Properties oauth2 = new OAuth2Properties();


}
