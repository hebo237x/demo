package com.hebo.elasticsearch;

import org.springframework.stereotype.Component;

/**
 * Created by hebo on 2017/3/9.
 */
@Component
public interface ClienteRepository {

    User findByUserName(String userName);

}
