package com.hebo.elasticsearch;

import org.springframework.stereotype.Service;

/**
 * Created by hebo on 2017/3/9.
 */
@Service
public class ClienteRepositoryImpl{

  /*  @Autowired
    private ClienteRepository clienteRepository;

    public User findByUserName(String userName){
        User ss = new User();
        List<User> users = new ArrayList<>();
        return clienteRepository.findByUserName(userName);
    }

    public User findOne(String id){
        return clienteRepository.findByUserName(id);
    }

    public void init(){
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(i+"");
            user.setUserName("hebo："+i);
            user.setAge(i);
            clienteRepository.save(user);
        }

    }*/
}
