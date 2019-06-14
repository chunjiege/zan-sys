package com.zan.hu.account.impl;

import com.zan.hu.account.AccountService;
import com.zan.hu.account.dto.AccountInputDTO;
import com.zan.hu.account.entity.Account;
import com.zan.hu.account.mapper.AccountMapper;
import com.zan.hu.account.message.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private MessageProvider messageProvider;

    @Override
    public void register(AccountInputDTO accountInputDto) throws Exception {
        Account account = selectByUsername(accountInputDto.getUsername());
        if (account != null) {
            throw new Exception("");
        }
        account = new Account();
        account.doForward(accountInputDto, account);
        account.setGuid(account.getGUuid());
        account.setPassword(passwordEncoder.encode(accountInputDto.getPassword()));
        accountMapper.insertSelective(account);
        //todo通知用户中心那边生成用户信息
        messageProvider.send(account.getGuid());
        System.out.println("sys发送消息成功");
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

    @Override
    public void insertBatch(List<AccountInputDTO> accountInputDTOs) {
        List<Account> accounts = new ArrayList<>();
        accountInputDTOs.forEach(p -> {
            p.setPassword(passwordEncoder.encode(p.getPassword()));
            Account account = new Account();
            account = account.doForward(p, account);
            account.setGuid(account.getGUuid());
            accounts.add(account);
        });
        accountMapper.insertBatchByAnnotations(accounts);
    }
}
