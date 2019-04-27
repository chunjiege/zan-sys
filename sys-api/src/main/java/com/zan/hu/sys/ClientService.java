package com.zan.hu.sys;

import com.zan.hu.sys.domain.Client;
import com.zan.hu.sys.query.ClientQuery;
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
     * @param clientQuery
     * @throws Exception
     */
    @PostMapping
    void create(@RequestBody ClientQuery clientQuery) throws Exception;

    /**
     * 更新oauth客户端
     *
     * @param clientQuery
     */
    @PutMapping
    void update(@RequestBody ClientQuery clientQuery) throws IllegalAccessException;


    /**
     * 删除oauth客户端
     *
     * @param id 主键
     */
    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id);


    /**
     * 分页批量查询
     *
     * @param clientQuery
     * @return
     */
    @GetMapping("/list")
    List<Client> page(ClientQuery clientQuery);

    /**
     * 根据clientId查找实例
     *
     * @param clientId
     * @return
     */
    @GetMapping("/clientId")
    Client selectByClientId(@RequestParam("clientId") String clientId);
}
