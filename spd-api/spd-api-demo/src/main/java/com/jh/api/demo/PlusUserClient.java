package com.jh.api.demo;

import com.jh.api.demo.fallbackfactory.PlusUserClientFallBackFactory;
import com.jh.common.model.base.ResponseMsg;
import com.jh.common.model.demo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "business-demo", path = "/plus/user", fallbackFactory = PlusUserClientFallBackFactory.class)
public interface PlusUserClient {

    @RequestMapping("/selectById/{id}")
    ResponseMsg<User> selectById(@PathVariable("id") Integer id);

    @RequestMapping("/selectList")
    ResponseMsg<List<User>> selectList();

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    ResponseMsg insert(@RequestBody User user);

}
