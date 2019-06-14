package com.zan.hu.account.query;

import lombok.Data;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-04-25 19:36
 * @Description todo
 **/
@Data
public class ClientConditionQuery {

    private String clientId;

    private String clientSecret;

    private String resourceIds;

    private String scope;

    private String authorities;
}
