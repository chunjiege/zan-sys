package com.zan.hu.account;

import com.zan.hu.account.dto.AccountInputDTO;
import com.zan.hu.account.entity.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-04-26 09:15
 * @Description todo
 **/
@RequestMapping("/api/account")
public interface AccountService {


    /**
     * 注册接口
     *
     * @param accountInputDto
     * @throws Exception
     */
    @PostMapping
    void register(@RequestBody AccountInputDTO accountInputDto) throws Exception;

    /**
     * 更新密码
     *
     * @param account,oldPassword,password
     */
    @PutMapping
    void update(String account, String oldPassword, String password) throws Exception;

    /**
     * @param username
     * @return
     */
    @GetMapping("/{username}")
    Account selectByUsername(@PathVariable("username") String username);

    @PostMapping("/batch")
    void insertBatch(@RequestBody List<AccountInputDTO> accountInputDTOs);
}
