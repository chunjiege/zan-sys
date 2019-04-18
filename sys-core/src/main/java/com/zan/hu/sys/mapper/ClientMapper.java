package com.zan.hu.sys.mapper;

import com.zan.hu.sys.domain.Client;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface ClientMapper extends Mapper<Client> {

    Client selectByClientId(String clientId);

    Client selectByClientIdOrClientSecret(@Param("clientId") String clientId, @Param("clientSecret") String clientSecret);
}