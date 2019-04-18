package com.zan.hu.sys;

import lombok.Data;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-04-10 14:30
 * @Description todo
 **/

@Data
public class SysClient {

    private String clientId;

    private String clientSecret;

    private String resourceIds;

    private String scope;

    private String authorities;
}
