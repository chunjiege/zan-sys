package com.zan.hu.sys;

import lombok.Data;

import java.util.UUID;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-04-10 14:30
 * @Description todo
 **/
@Data
public class SysGlobalUser {

    private String account;

    private String password;

    public String getGuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
