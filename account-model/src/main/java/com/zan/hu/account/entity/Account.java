package com.zan.hu.account.entity;

import com.zan.hu.common.utils.convert.BeanComUtils;
import com.zan.hu.common.utils.convert.Converter;
import com.zan.hu.account.dto.AccountInputDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.*;

@Table(name = "`account`")
@Data
public class Account extends Converter<AccountInputDTO, Account> implements Serializable {
    /**
     * 用户 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户全局 ID
     */
    private String guid;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户锁定
     */
    private Boolean locked;

    private Boolean enabled;

    /**
     * 用户过期
     */
    private Boolean expired;

    private Date created;

    private Date updated;

    private static final long serialVersionUID = 1L;


    public String getGUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public AccountInputDTO doBackward(Account account, AccountInputDTO accountInputDTO) {
        return null;
    }

    @Override
    public Account doForward(AccountInputDTO accountInputDto, Account account, String[] ignoreProperties) {
        BeanComUtils.copyProperties(accountInputDto, account, ignoreProperties);
        return account;
    }

    @Override
    public Account doForward(AccountInputDTO accountInputDto, Account account) {
        BeanComUtils.copyProperties(accountInputDto, account);
        return account;
    }

}