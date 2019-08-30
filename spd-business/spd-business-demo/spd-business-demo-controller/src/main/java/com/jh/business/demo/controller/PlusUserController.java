package com.jh.business.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jh.business.demo.mapper.mybatisplus.PlusUserMapper;
import com.jh.common.enums.RetCode;
import com.jh.common.model.base.ResponseMsg;
import com.jh.common.model.demo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plus/user")
public class PlusUserController {

    private Logger logger = LoggerFactory.getLogger(PlusUserController.class);

    @Autowired
    private PlusUserMapper plusUserMapper;

    @RequestMapping("/selectById/{id}")
    public ResponseMsg<User> selectById(@PathVariable("id") Integer id) {
        logger.info("selectById：根据id查询 user 信息，id = {}", id);
        User user = plusUserMapper.selectById(id);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, user);
    }

    @RequestMapping(value = "/selectBatchIds")
    public ResponseMsg selectBatchIds(@RequestBody List<Integer> idsList) {
        logger.info("selectBatchIds：根据ids查询 user 集合信息，idsList = {}", idsList);
        List<User> userList = plusUserMapper.selectBatchIds(idsList);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, userList);
    }

    @RequestMapping(value = "/selectByMap", method = RequestMethod.POST)
    public ResponseMsg selectByMap(@RequestBody Map<String, Object> map) {
        logger.info("selectByMap：根据条件查询 user 集合信息，map = {}", map);
        List<User> userList = plusUserMapper.selectByMap(map);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, userList);
    }

    @RequestMapping(value = "/selectOne", method = RequestMethod.POST)
    public ResponseMsg selectOne(@RequestBody User user) {
        logger.info("selectOne：根据条件查询 user 信息，user = {}", user);
        User result = plusUserMapper.selectOne(new QueryWrapper<User>().setEntity(user));
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, result);
    }

    @RequestMapping("/selectList")
    public ResponseMsg<List<User>> selectList() {
        logger.info("selectList：查询所有 user");
        List<User> userList = plusUserMapper.selectList(null);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, userList);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseMsg insert(@RequestBody User user) {
        logger.info("insert：新增一条 user 信息，user = {}", user);
        int row = plusUserMapper.insert(user);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.POST)
    public ResponseMsg deleteById(@PathVariable("id") Integer id) {
        logger.info("deleteById：根据 id 删除一条 user 信息，id = {}", id);
        int row = plusUserMapper.deleteById(id);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

    @RequestMapping(value = "/deleteByMap", method = RequestMethod.POST)
    public ResponseMsg deleteByMap(@RequestBody Map<String, Object> map) {
        logger.info("deleteById：根据 map 条件删除 user 信息，map = {}", map);
        int row = plusUserMapper.deleteByMap(map);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseMsg delete(@PathVariable("id") Integer id) {
        logger.info("deleteById：根据条件删除 user 信息，id = {}", id);
        int row = plusUserMapper.delete(new QueryWrapper<User>().eq("id", id));
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

    @RequestMapping(value = "/deleteBatchIds", method = RequestMethod.POST)
    public ResponseMsg deleteBatchIds(@RequestBody List<Integer> idsList) {
        logger.info("deleteById：根据 ids 删除 user 信息，idsList = {}", idsList);
        int row = plusUserMapper.deleteBatchIds(idsList);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    public ResponseMsg updateById(@RequestBody User user) {
        logger.info("updateById：根据 id 修改一条 user 信息，user = {}", user);
        int row = plusUserMapper.updateById(user);
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseMsg update(@RequestBody User user) {
        logger.info("update：根据条件修改 user 信息，user = {}", user);
        int row = plusUserMapper.update(user, new UpdateWrapper<User>().setEntity(user));
        return new ResponseMsg<>(RetCode.SUCC.getDesc(), null, row);
    }

}
