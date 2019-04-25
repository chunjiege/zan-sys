package com.zan.hu.sys.impl;

import com.zan.hu.common.utils.BeanComUtils;
import com.zan.hu.sys.ClientService;
import com.zan.hu.sys.SysClient;
import com.zan.hu.sys.domain.Client;
import com.zan.hu.sys.mapper.ClientMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version 1.0
 * @Author admin
 * @Date 2019-04-04 13:23
 * @Description todo
 **/
@RestController
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void createClient(SysClient sysClient) throws Exception {
        Client client = clientMapper.selectByClientIdOrClientSecret(sysClient.getClientId(), sysClient.getClientSecret());
        if (client != null) {
            throw new Exception("");
        }
        client = new Client();
        BeanComUtils.copyProperties(sysClient, client);
        client.setClientSecret(passwordEncoder.encode(client.getClientSecret()));
        clientMapper.insertSelective(client);
    }

    @Override
    public void updateClient(SysClient sysClient) throws IllegalAccessException {
        Client client = clientMapper.selectByClientId(sysClient.getClientId());
        if (client != null) {
            String[] attributes = BeanComUtils.checkObjFieldIsNull(sysClient);
            BeanComUtils.copyProperties(sysClient, client, attributes);
            clientMapper.updateByPrimaryKeySelective(client);
        }
    }


    @Override
    public void deleteClient(Long clientId) {

    }

    @Override
    public List<SysClient> list() {
        return null;
    }

    @Override
    public Client selectByClientId(String clientId) {
        Client client = clientMapper.selectByClientId(clientId);
        return client;
    }


}
