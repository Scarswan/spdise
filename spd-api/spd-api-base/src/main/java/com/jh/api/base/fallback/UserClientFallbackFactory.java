package com.jh.api.base.fallback;

import com.jh.api.base.UserClient;
import com.jh.common.enums.RetCode;
import com.jh.common.model.base.ResponseMsg;
import com.jh.common.model.base.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {

    private Logger log = LoggerFactory.getLogger(UserClientFallbackFactory.class);

    @Override
    public UserClient create(Throwable cause) {
        return new UserClientFallBack() {
            @Override
            public ResponseMsg<User> get(User user) {
                log.error("Base Feign API 调用出错："+ cause.getMessage());
                 cause.printStackTrace();
                return ResponseMsg.error(RetCode.FAIL);
            }
        };
    }
}
