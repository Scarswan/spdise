package com.jh.business.demo.service;

import com.jh.common.model.demo.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

@Service
public interface SampleEntityRepository extends ElasticsearchRepository<User, Integer> {

}