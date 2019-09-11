package com.jh.api.demo.fallbackfactory;

import com.jh.api.demo.PlusUserClient;
import com.jh.common.enums.RetCode;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.model.demo.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlusUserClientFallBackFactory implements FallbackFactory<PlusUserClient> {

    private Logger logger = LoggerFactory.getLogger(PlusUserClientFallBackFactory.class);

    @Override
    public PlusUserClient create(Throwable throwable) {
        logger.error("Demo服务调用失败", throwable);
        return new PlusUserClient() {
            @Override
            public ResponseMsg<User> selectById(Integer id) {
                logger.error("/plus/user/selectById 出错, id = {}", id);
                return ResponseMsg.error(RetCode.CODE_999902, throwable.getMessage());
            }

            @Override
            public ResponseMsg<List<User>> selectList() {
                logger.error("/plus/user/selectList 出错");
                return ResponseMsg.error(RetCode.CODE_999902, throwable.getMessage());
            }

            @Override
            public ResponseMsg insert(User user) {
                logger.error("/plus/user/insert 出错, user = {}", user);
                return ResponseMsg.error(RetCode.CODE_999902, throwable.getMessage());
            }
        };
    }
}
