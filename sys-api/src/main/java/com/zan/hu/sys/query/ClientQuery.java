package com.zan.hu.sys.query;

import com.zan.hu.common.model.query.BaseQuery;
import lombok.Data;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-04-25 19:36
 * @Description todo
 **/
@Data
public class ClientQuery extends BaseQuery {

    private String clientId;

    private String clientSecret;

    private String resourceIds;

    private String scope;

    private String authorities;
}
