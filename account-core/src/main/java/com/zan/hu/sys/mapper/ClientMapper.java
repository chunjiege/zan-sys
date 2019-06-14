package com.zan.hu.sys.mapper;

import com.zan.hu.sys.entity.Client;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import tk.mybatis.mapper.common.Mapper;

@CacheConfig(cacheNames = "client")
public interface ClientMapper extends Mapper<Client> {

    @Cacheable(key = "#p0")
    Client selectByClientId(String clientId);

    Client selectByClientIdOrClientSecret(@Param("clientId") String clientId, @Param("clientSecret") String clientSecret);
}