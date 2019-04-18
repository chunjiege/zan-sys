package com.zan.hu.sys;

import com.zan.hu.sys.domain.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version 1.0
 * @Author admin
 * @Date 2019-04-04 13:20
 * @Description todo
 **/
@RequestMapping("/api/client")
public interface ClientService {

    @PostMapping
    void createClient(@RequestBody SysClient sysClient) throws Exception;

    @GetMapping("/clientId")
    Client selectByClientId(@RequestParam("clientId") String clientId);
}
