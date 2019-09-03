package com.jh.api.base.fallbackfactory;

import com.jh.api.base.UserClient;
import com.jh.common.enums.RetCode;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.model.base.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {

    private Logger logger = LoggerFactory.getLogger(UserClientFallbackFactory.class);

    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public ResponseMsg<User> getUserInfo(User user) {
                logger.error("FeignAPI-base调用 business-base:getUserInfo 出错, user = {}, 异常信息：{}", user, throwable.getMessage());
                throwable.printStackTrace();

                return ResponseMsg.error(RetCode.FAIL);
            }

            @Override
            public ResponseMsg loginOrRegister(User user) {
                logger.error("FeignAPI-base调用 business-base:loginOrRegister 出错, user = {}, 异常信息：{}", user, throwable.getMessage());
                throwable.printStackTrace();

                return ResponseMsg.error(RetCode.FAIL);
            }

            @Override
            public ResponseMsg<List<User>> listUser() {
                logger.error("FeignAPI-base调用 business-base:listUser 出错,异常信息：{}", throwable.getMessage());
                throwable.printStackTrace();

                return ResponseMsg.error(RetCode.FAIL);
            }
        };
    }
}
