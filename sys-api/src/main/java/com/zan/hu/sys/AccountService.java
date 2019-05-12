package com.zan.hu.sys;

import com.zan.hu.sys.domain.Account;
import com.zan.hu.sys.query.AccountQuery;
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
 * @Author hupeng
 * @Date 2019-04-26 09:15
 * @Description todo
 **/
@RequestMapping("/api/account")
public interface AccountService {


    /**
     * 注册接口
     *
     * @param accountQuery
     * @throws Exception
     */
    @PostMapping
    void register(@RequestBody AccountQuery accountQuery) throws Exception;

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
    void insertBatch();
}
