package com.jh.api.demo.fallbackfactory;

import com.jh.api.demo.PlusUserClient;
import com.jh.common.enums.RetCode;
import com.jh.common.model.base.ResponseMsg;
import com.jh.common.model.demo.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlusUserClientFallBackFactory implements FallbackFactory<PlusUserClient> {

    private Logger log = LoggerFactory.getLogger(PlusUserClientFallBackFactory.class);

    @Override
    public PlusUserClient create(Throwable throwable) {
        return new PlusUserClient() {
            @Override
            public ResponseMsg<User> selectById(Integer id) {
                log.error("FeignAPI-demo调用 business-demo:selectById 出错, id = {}, 异常信息：{}", id, throwable.getMessage());
                throwable.printStackTrace();

                return ResponseMsg.error(RetCode.FAIL);
            }

            @Override
            public ResponseMsg<List<User>> selectList() {
                log.error("FeignAPI-demo调用 business-demo:selectById 出错, 异常信息：{}", throwable.getMessage());
                throwable.printStackTrace();

                return ResponseMsg.error(RetCode.FAIL);
            }

            @Override
            public ResponseMsg insert(User user) {
                log.error("FeignAPI-demo调用 business-demo:insert 出错, user = {}, 异常信息：{}", user, throwable.getMessage());
                throwable.printStackTrace();

                return ResponseMsg.error(RetCode.FAIL);
            }
        };
    }
}
