package com.zan.hu.sys.config;

import com.zan.hu.jwt.ResourceServerConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-04-09 10:48
 * @Description todo
 **/
@Configuration
@EnableResourceServer
public class ResourceConf extends ResourceServerConf {


    @Autowired
    private TokenStore tokenStore;

    private static final String RESOURCE_ID = "sys-server";

    public TokenStore tokenStore() {
        return tokenStore;
    }

    public String resourceId() {
        return RESOURCE_ID;
    }


}
