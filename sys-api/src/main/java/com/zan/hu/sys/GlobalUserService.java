package com.zan.hu.sys;

import com.zan.hu.sys.domain.GlobalUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version 1.0
 * @Author admin
 * @Date 2019-04-04 13:21
 * @Description todo
 **/
@RequestMapping("/api/global")
public interface GlobalUserService {

    @PostMapping
    void register(@RequestBody SysGlobalUser sysGlobalUser) throws Exception;

    @GetMapping("/account")
    GlobalUser selectByAccount(@RequestParam("account") String account);

}
