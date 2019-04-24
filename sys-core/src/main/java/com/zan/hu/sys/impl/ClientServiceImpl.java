package com.zan.hu.sys.impl;

import com.zan.hu.sys.ClientService;
import com.zan.hu.sys.SysClient;
import com.zan.hu.sys.domain.Client;
import com.zan.hu.sys.mapper.ClientMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.ArrayList;
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
        BeanUtils.copyProperties(sysClient, client);
        client.setClientSecret(passwordEncoder.encode(client.getClientSecret()));
        clientMapper.insertSelective(client);
    }

    @Override
    public void updateClient(SysClient sysClient) throws IllegalAccessException {
        Client client = clientMapper.selectByClientId(sysClient.getClientId());
        if (client != null) {
            String[] attributes = checkObjFieldIsNull(sysClient);
            BeanUtils.copyProperties(sysClient, client, attributes);
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


    /**
     *  is check attribute null
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static String[] checkObjFieldIsNull(Object obj) throws IllegalAccessException {
        if (obj == null)
            return null;
        List<String> attributes = new ArrayList<>();
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            log.info(f.getName());
            if (f.get(obj) == null || f.get(obj).equals("")) {
                attributes.add(f.getName());
            }
        }
        String[] attribute = !StringUtils.isEmpty(attributes) ? attributes.toArray(new String[attributes.size()]) : null;
        return attribute;
    }
}
