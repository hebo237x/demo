package com.hebo.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hebo on 2017/3/9.
 */
@Service
public class ClienteRepositoryImpl{

    @Autowired
    private ClienteRepository clienteRepository;

    public User findByUserName(String userName){
        User ss = new User();
        List<User> users = new ArrayList<>();
        clienteRepository.save(users);
        return clienteRepository.findByUserName(userName);
    }

    public User findOne(String id){
        return clienteRepository.findOne(id);
    }

    public void init(){
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(i+"");
            user.setUserName("hebo："+i);
            user.setAge(i);
            clienteRepository.save(user);
        }

    }
}
