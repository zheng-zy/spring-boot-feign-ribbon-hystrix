package com.example.controller;

import com.example.client.UserClient;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>fegin test</p>
 * Created by @author zhezhiyong@163.com on 2018/11/2.
 */
@RestController
@Slf4j
public class FeignController {

    @Autowired
    private UserClient userClient;

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public Map<String, Object> getUser(@PathVariable Integer id) {
        log.info("收到客户端请求getUser id:{}", id);
        return userClient.getUser(ImmutableMap.of("id", id));
    }

}
