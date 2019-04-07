package com.zan.hu.sys.impl;

import com.zan.hu.auth.SysGlobalUser;
import com.zan.hu.auth.domin.GlobalUser;
import com.zan.hu.sys.GlobalUserService;
import com.zan.hu.sys.mapper.GlobalUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author admin
 * @Date 2019-04-04 13:23
 * @Description todo
 **/
@RestController
public class GlobalUserServiceImpl implements GlobalUserService {

    @Autowired
    private GlobalUserMapper globalUserMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(SysGlobalUser sysGlobalUser) throws Exception {
        GlobalUser globalUser = globalUserMapper.selectByAccount(sysGlobalUser.getAccount());
        if (globalUser != null) {
            throw new Exception("");
        }
        globalUser = new GlobalUser();
        BeanUtils.copyProperties(sysGlobalUser, globalUser);
        globalUser.setGuid(sysGlobalUser.getGuid());
        globalUser.setPassword(passwordEncoder.encode(sysGlobalUser.getPassword()));
        globalUserMapper.insertSelective(globalUser);
    }

    public Object getAuthentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        return auth.getPrincipal();
    }
}
