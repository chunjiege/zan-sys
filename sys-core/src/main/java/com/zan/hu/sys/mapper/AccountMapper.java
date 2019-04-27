package com.zan.hu.sys.mapper;

import com.zan.hu.sys.domain.Account;
import tk.mybatis.mapper.common.Mapper;

public interface AccountMapper extends Mapper<Account> {

    Account selectByUsername(String username);
}