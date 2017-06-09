package com.hebo.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * Created by hebo on 2017/3/9.
 */
@Component
public interface ClienteRepository extends ElasticsearchRepository<User,String> {

    User findByUserName(String userName);

}
