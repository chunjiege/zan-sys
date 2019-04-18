package com.zan.hu.sys.mapper;

import com.zan.hu.sys.domain.GlobalUser;
import tk.mybatis.mapper.common.Mapper;

public interface GlobalUserMapper extends Mapper<GlobalUser> {

    GlobalUser selectByAccount(String account);

}