package com.zan.hu.sys.impl;

import com.zan.hu.common.utils.BeanComUtils;
import com.zan.hu.sys.ClientService;
import com.zan.hu.sys.domain.Client;
import com.zan.hu.sys.mapper.ClientMapper;
import com.zan.hu.sys.query.ClientQuery;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
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
    public void create(ClientQuery clientQuery) throws Exception {
        Client client = clientMapper.selectByClientIdOrClientSecret(clientQuery.getClientId(), clientQuery.getClientSecret());
        if (client != null) {
            throw new Exception("");
        }
        client = new Client();
        BeanComUtils.copyProperties(client, client);
        client.setClientSecret(passwordEncoder.encode(client.getClientSecret()));
        clientMapper.insertSelective(client);
    }

    @Override
    public void update(ClientQuery clientQuery) throws IllegalAccessException {
        Client client = clientMapper.selectByClientId(clientQuery.getClientId());
        if (client != null) {
            String[] attributes = BeanComUtils.checkObjFieldIsNull(clientQuery);
            BeanComUtils.copyProperties(clientQuery, client, attributes);
            clientMapper.updateByPrimaryKeySelective(client);
        }
    }


    @Override
    public void delete(Long id) {
        clientMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Client> page(ClientQuery clientQuery) {
        Client clientPara = new Client();
        RowBounds rowBounds = new RowBounds();
        List<Client> clients = clientMapper.selectByExampleAndRowBounds(clientPara, rowBounds);
        return clients;
    }

    @Override
    public Client selectByClientId(String clientId) {
        Client client = clientMapper.selectByClientId(clientId);
        return client;
    }


}
