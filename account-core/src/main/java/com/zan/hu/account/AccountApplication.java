package com.zan.hu.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-04-07 01:44
 * @Description todo
 **/
@SpringCloudApplication
@ComponentScan("com.zan.hu")
@MapperScan("com.zan.hu.account.mapper")
@ServletComponentScan
@EnableCaching
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
