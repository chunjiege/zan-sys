//package com.zan.hu.sys.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @version 1.0
// * @Author hupeng
// * @Date 2019-04-18 19:22
// * @Description todo
// **/
//@Configuration
//@EnableWebSecurity
//public class SecurityWhitelistHandler extends WebSecurityConfigurerAdapter {
//
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                //不拦截swagger
//                .antMatchers("/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**")
//                .antMatchers(HttpMethod.POST, "/api/global");
//    }
//
//}
