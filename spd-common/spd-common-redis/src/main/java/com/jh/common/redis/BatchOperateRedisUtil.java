package com.jh.common.redis;

import com.alibaba.fastjson.JSON;
import com.jh.common.enums.YesNoEnum;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * @Description 批量操作redis类
 **/
@Service
public class BatchOperateRedisUtil {
    private Logger logger = LoggerFactory.getLogger(BatchOperateRedisUtil.class.getName());

    @Autowired
    private RedisUtil redisUtil;


    /**
     * @Description 批量操作
     **/
    @Transactional
    public BatchOperateResult batchOperate(String redisKey, List<String> toLockNos, long expire, String memberName, Function<List<String>, Boolean> func) {
        logger.info("开始批量操作单号{},{}", JSON.toJSONString(toLockNos), memberName);
        BatchOperateResult batchOperateResult = new BatchOperateResult();
        //查看要操作的单号是否被人锁定
        List<RedisObj> locked = isLocked(redisKey, toLockNos);
        //存在单号被人锁定，返回被锁定信息
        if (locked.size() > 0) {
            batchOperateResult.setResult(YesNoEnum.NO_CODE.getCode());
            batchOperateResult.setFailedData(locked);
            return batchOperateResult;
        }
        //开始锁定单号
        locked = lockLockNos(redisKey, toLockNos, expire, memberName);
        //判断是否存在单号被人锁定， 如果存在，解锁锁定成功的，返回被锁定信息
        if (locked.size() > 0) {
            //深度复制
            List<String> toUnlockNos = new ArrayList<>();
            for (String lockNo : toLockNos) {
                toUnlockNos.add(new String(lockNo));
            }
            //去除被别人锁定的
            for (RedisObj obj : locked) {
                toUnlockNos.remove(obj.getLockNo());
            }
            //解锁被自己锁定的
            unlockLockNos(redisKey, toUnlockNos);
            //返回失败信息
            batchOperateResult.setResult(YesNoEnum.NO_CODE.getCode());
            batchOperateResult.setFailedData(locked);
            return batchOperateResult;
        }
        try {
            func.apply(toLockNos);
        } finally {
            //无论成功失败，操作完成后，解锁被锁定的的单号
            unlockLockNos(redisKey, toLockNos);
        }

        batchOperateResult.setResult(YesNoEnum.YES_CODE.getCode());
        return batchOperateResult;
    }


    private List<RedisObj> isLocked(String redisKey, List<String> toLockNos) {
        logger.info("开始查看单号{}是否被{}锁定", JSON.toJSONString(toLockNos), redisKey);
        List<RedisObj> bns = new ArrayList<>();
        for (String lockNo : toLockNos) {
            String key = redisKey + ":" + lockNo;
            RedisObj object = redisUtil.getObject(key, RedisObj.class);
            if (!Objects.isNull(object) && Objects.equals(lockNo, object.getLockNo())) {
                bns.add(object);
            }
        }
        logger.info("被锁定信息{}", JSON.toJSONString(bns));
        return bns;
    }

    private List<RedisObj> lockLockNos(String redisKey, List<String> toLockNos, long expire, String memberName) {
        logger.info("开始锁定单号{}，{},{},{}", redisKey, JSON.toJSONString(toLockNos), expire, memberName);
        List<RedisObj> bns = new ArrayList<>();
        for (String lockNo :
                toLockNos) {

            String key = redisKey + ":" + lockNo;
            RedisObj object1 = redisUtil.getObject(key, RedisObj.class);
            if (object1 != null && Objects.equals(lockNo, object1.getLockNo())) {
                bns.add(object1);
            } else {
                RedisObj object = new RedisObj();
                object.setLockNo(lockNo);
                object.setMemberName(memberName);
                redisUtil.setObject(redisKey, object, expire);
            }

        }
        logger.info("被锁定信息{}", JSON.toJSONString(bns));
        return bns;
    }

    private void unlockLockNos(String redisKey, List<String> lockNos) {
        logger.info("开始解锁被锁定的信息{},{}", redisKey, JSON.toJSONString(lockNos));
        for (String lockNo :
                lockNos) {
            RedisObj object = new RedisObj();
            object.setLockNo(lockNo);
            String key = redisKey + ":" + lockNo;
            redisUtil.delete(key);
        }
    }


    /**
     * @Description 存数据到redis所用类
     **/
    @Data
    private static class RedisObj {
        /**
         * 要锁定的id
         **/
        private String lockNo;

        /**
         * @Author peishuaihui
         **/
        private String memberName;
    }

    /**
     * @Description 批量操作的结果
     **/
    @Data
    private static class BatchOperateResult {
        /**
         * 操作结果 1 成功 2 失败
         **/
        private Integer result;

        /**
         * 锁定失败的票号
         **/
        private List<RedisObj> failedData;
    }


    public static void main(String[] args) {
        BatchOperateRedisUtil b = new BatchOperateRedisUtil();
        BatchOperateResult batchOperateResult = b.batchOperate("key", Arrays.asList("1", "2"), 1000, "dkfj", new Function<List<String>, Boolean>() {
            @Override
            public Boolean apply(List<String> strings) {
                //业务方法
                return null;
            }
        });
        if (Objects.equals(batchOperateResult.getResult(), YesNoEnum.YES_CODE.getCode())) {
            //操作成功
        } else {
            //操作失败
            List<RedisObj> failedData = batchOperateResult.getFailedData();
        }
    }

}
