package com.jh.business.demo.controller;

import com.jh.business.demo.service.SampleEntityRepository;
import com.jh.common.model.demo.User;
import com.jh.common.model.response.ResponseMsg;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/es")
public class ESController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private SampleEntityRepository sampleEntityRepository;


    @RequestMapping("/create")
    public ResponseMsg createIndex() {
        // 创建索引
        elasticsearchTemplate.createIndex(User.class);
        // 更新mapping配置
        elasticsearchTemplate.putMapping(User.class);
        // 删除索引
        elasticsearchTemplate.deleteIndex(User.class);
        // 刷新索引
        elasticsearchTemplate.refresh(User.class);

        return ResponseMsg.success();
    }

    @RequestMapping("/add")
    public ResponseMsg addData() {
        for (int i = 1; i <= 15; i++) {

            int documentId = i;
            User sampleEntity = new User();
            sampleEntity.setId(documentId);
            sampleEntity.setName(documentId + "ZhangSan");
            sampleEntity.setAge((int) (i * (Math.random() * 100)));
            sampleEntity = sampleEntityRepository.save(sampleEntity);
        }

        return ResponseMsg.success();
    }

    @RequestMapping("/search")
    public ResponseMsg search() {
        // 指定指定排序
        Sort sort = Sort.by(Sort.Direction.ASC, "message");
        // 查询所有数据
        Iterable<User> list = sampleEntityRepository.findAll(sort);
        System.out.println(list);
        // 条件查询
        QueryBuilder query = QueryBuilders.matchQuery("message", "上海");
        // 指定分页参数
        Pageable page = PageRequest.of(0, 5, sort);
        list = sampleEntityRepository.search(query, page);
        System.out.println(list);

        return ResponseMsg.success(list);
    }

}
