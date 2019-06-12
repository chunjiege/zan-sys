package com.zan.hu.sys;

import com.zan.hu.sys.dto.ClientInputDTO;
import com.zan.hu.sys.entity.Client;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
     * @param clientInputDTO
     * @throws Exception
     */
    @PostMapping
    void create(@RequestBody ClientInputDTO clientInputDTO) throws Exception;

    /**
     * 更新oauth客户端
     *
     * @param clientInputDTO
     */
    @PutMapping
    void update(@RequestBody ClientInputDTO clientInputDTO) throws IllegalAccessException;


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
     * @param clientInputDTO
     * @return
     */
    @GetMapping("/list")
    List<Client> page(ClientInputDTO clientInputDTO);

    /**
     * 根据clientId查找实例
     *
     * @param clientId
     * @return
     */
    @GetMapping("/{clientId}")
    Client selectByClientId(@PathVariable("clientId") String clientId);
}
