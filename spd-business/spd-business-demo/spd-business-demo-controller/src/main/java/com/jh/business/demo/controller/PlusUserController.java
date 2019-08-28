package com.jh.business.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jh.business.demo.mapper.mybatisplus.PlusUserMapper;
import com.jh.common.enums.RetCode;
import com.jh.common.model.base.ResponseMsg;
import com.jh.common.model.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plus/user")
public class PlusUserController {

    @Autowired
    private PlusUserMapper plusUserMapper;

    @RequestMapping("/selectById/{id}")
    public ResponseMsg<User> selectById(@PathVariable("id") Integer id) {
        System.out.println(("----- selectById method test ------"));
        User user = plusUserMapper.selectById(id);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, user);
    }

    @RequestMapping(value = "/selectBatchIds")
    public ResponseMsg selectBatchIds(@RequestBody List<Integer> idsList) {
        System.out.println(("----- selectBatchIds method test ------"));
        List<User> userList = plusUserMapper.selectBatchIds(idsList);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, userList);
    }

    @RequestMapping(value = "/selectByMap", method = RequestMethod.POST)
    public ResponseMsg selectByMap(@RequestBody Map<String, Object> map) {
        System.out.println(("----- userList method test ------"));
        List<User> userList = plusUserMapper.selectByMap(map);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, userList);
    }

    @RequestMapping(value = "/selectOne", method = RequestMethod.POST)
    public ResponseMsg selectOne(@RequestBody User user) {
        System.out.println(("----- selectOne method test ------"));
        User result = plusUserMapper.selectOne(new QueryWrapper<User>().setEntity(user));
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, result);
    }

    @RequestMapping("/selectList")
    public ResponseMsg<List<User>> selectList() {
        System.out.println(("----- selectList method test ------"));
        List<User> userList = plusUserMapper.selectList(null);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, userList);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseMsg insert(@RequestBody User user) {
        System.out.println(("----- insert method test ------"));
        int row = plusUserMapper.insert(user);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.POST)
    public ResponseMsg deleteById(@PathVariable("id") Integer id) {
        System.out.println(("----- deleteById method test ------"));
        int row = plusUserMapper.deleteById(id);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

    @RequestMapping(value = "/deleteByMap", method = RequestMethod.POST)
    public ResponseMsg deleteByMap(@RequestBody Map<String, Object> map) {
        System.out.println(("----- deleteByMap method test ------"));
        int row = plusUserMapper.deleteByMap(map);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseMsg delete(@PathVariable("id") Integer id) {
        System.out.println(("----- delete method test ------"));
        int row = plusUserMapper.delete(new QueryWrapper<User>().eq("id", id));
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

    @RequestMapping(value = "/deleteBatchIds", method = RequestMethod.POST)
    public ResponseMsg deleteBatchIds(@RequestBody List<Integer> idsList) {
        System.out.println(("----- deleteBatchIds method test ------"));
        int row = plusUserMapper.deleteBatchIds(idsList);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    public ResponseMsg updateById(@RequestBody User user) {
        System.out.println(("----- updateById method test ------"));
        int row = plusUserMapper.updateById(user);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseMsg update(@RequestBody User user) {
        System.out.println(("----- update method test ------"));
        int row = plusUserMapper.update(user, new UpdateWrapper<User>().setEntity(user));
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

}
