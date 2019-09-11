package com.jh.api.base.fallbackfactory;

import com.github.pagehelper.PageInfo;
import com.jh.api.base.UserClient;
import com.jh.common.dto.base.UserDTO;
import com.jh.common.enums.RetCode;
import com.jh.common.model.response.ResponseMsg;
import com.jh.common.model.base.User;
import com.jh.common.vo.base.UserVO;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {

    private Logger logger = LoggerFactory.getLogger(UserClientFallbackFactory.class);

    @Override
    public UserClient create(Throwable throwable) {
        logger.error("Base服务调用失败", throwable);
        return new UserClient() {
            @Override
            public ResponseMsg loginOrRegister(UserDTO userDTO) {
                logger.error("/user/login/register 出错, userDTO = {}", userDTO);
                return ResponseMsg.error(RetCode.CODE_999901, throwable.getMessage());
            }

            @Override
            public ResponseMsg<PageInfo<UserVO>> queryUser(@RequestBody UserDTO userDTO) {
                logger.error("/user/list/user 出错, userDTO = {}", userDTO);
                return ResponseMsg.error(RetCode.CODE_999901, throwable.getMessage());
            }
        };
    }
}
