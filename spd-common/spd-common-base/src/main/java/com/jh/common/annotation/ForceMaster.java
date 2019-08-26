package com.jh.common.annotation;

import java.lang.annotation.*;

/**
 * ShardingSphere 强制路由主库注解
 * @author YangFu
 * @date 2019/08/26 17:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ForceMaster {

    String value() default "";

}
