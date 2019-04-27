package com.zan.hu.sys.impl;

import com.zan.hu.sys.AccountService;
import com.zan.hu.sys.domain.Account;
import com.zan.hu.sys.mapper.AccountMapper;
import com.zan.hu.sys.query.AccountQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-04-26 09:15
 * @Description todo
 **/
@RestController
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(AccountQuery accountQuery) throws Exception {
        Account account = selectByUsername(accountQuery.getUsername());
        if (account != null) {
            throw new Exception("");
        }
        account = new Account();
        BeanUtils.copyProperties(accountQuery, account);
        account.setGuid(account.getGUuid());
        account.setPassword(passwordEncoder.encode(accountQuery.getPassword()));
        accountMapper.insertSelective(account);
        //todo通知用户中心那边生成用户信息
    }

    @Override
    public void update(String username, String oldPassword, String password) throws Exception {
        Account account = selectByUsername(username);
        if (account == null)
            throw new Exception("");
        boolean matches = passwordEncoder.matches(oldPassword, account.getPassword());
        if (matches) {
            account.setPassword(passwordEncoder.encode(password));
            accountMapper.updateByPrimaryKeySelective(account);
        }
    }

    @Override
    public Account selectByUsername(String username) {
        Account account = accountMapper.selectByUsername(username);
        return account;
    }
}
