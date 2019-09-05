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
        return new UserClient() {

            @Override
            public ResponseMsg loginOrRegister(UserDTO userDTO) {
                logger.error("FeignAPI-base调用 business-base:/login/register 出错, userDTO = {}, 异常信息：{}", userDTO, throwable.getMessage());
                throwable.printStackTrace();

                return ResponseMsg.error(RetCode.FAIL);
            }

            @Override
            public ResponseMsg<PageInfo<UserVO>> queryUser(@RequestBody UserDTO userDTO) {
                logger.error("FeignAPI-base调用 business-base:/list/user 出错, userDTO = {} ,异常信息：{}", userDTO, throwable.getMessage());
                throwable.printStackTrace();

                return ResponseMsg.error(RetCode.FAIL);
            }
        };
    }
}
