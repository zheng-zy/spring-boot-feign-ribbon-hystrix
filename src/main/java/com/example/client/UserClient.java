package com.example.client;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * <p>用户接口</p>
 * Created by @author zhezhiyong@163.com on 2018/11/2.
 */
@FeignClient(name = "user", fallback = UserClient.UserFallback.class)
@RibbonClient(name = "user")
public interface UserClient {

    /**
     * 测试
     *
     * @param data 测试数据
     * @return 测试数据
     */
    @RequestMapping(method = RequestMethod.POST,
            value = "/getUser",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    Map<String, Object> getUser(Map<String, Object> data);

    @Slf4j
    @Component
    class UserFallback implements UserClient {
        @Override
        public Map<String, Object> getUser(Map<String, Object> data) {
            log.error("fallback:" + JSON.toJSONString(data));
            return ImmutableMap.of("code", -1, "msg", "获取用户信息失败");
        }
    }

}
