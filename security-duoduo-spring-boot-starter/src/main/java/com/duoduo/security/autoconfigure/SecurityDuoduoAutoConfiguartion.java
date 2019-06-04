package com.duoduo.security.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @desc 自动配置类
 * @author lixiaolong
 * @create 2019-06-04 10:32
 */
@Configuration
@EnableConfigurationProperties(SecurityDuoduoProperties.class)
public class SecurityDuoduoAutoConfiguartion {
}
