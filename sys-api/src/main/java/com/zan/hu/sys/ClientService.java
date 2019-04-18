package com.zan.hu.sys;

import com.zan.hu.sys.domain.Client;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @version 1.0
 * @Author admin
 * @Date 2019-04-04 13:20
 * @Description todo
 **/
@RequestMapping("/api/client")
public interface ClientService {

    /**
     * 创建oauth客户端
     *
     * @param sysClient
     * @throws Exception
     */
    @PostMapping
    void createClient(@RequestBody SysClient sysClient) throws Exception;

    /**
     * 更新oauth客户端
     *
     * @param sysClient
     */
    @PutMapping
    void updateClient(@RequestBody SysClient sysClient);

    @DeleteMapping("/{clientId}")
    void deleteClient(@PathVariable("clientId") Long clientId);


    List<SysClient> list();

    @GetMapping("/clientId")
    Client selectByClientId(@RequestParam("clientId") String clientId);
}
