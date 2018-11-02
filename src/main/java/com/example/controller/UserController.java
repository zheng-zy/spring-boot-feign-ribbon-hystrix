package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>用户接口</p>
 * Created by @author zhezhiyong@163.com on 2018/11/2.
 */
@RestController
@Slf4j
public class UserController {

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public Map<String, Object> getUser(@RequestBody Map<String, Object> params, HttpServletRequest request) {
        log.info("来自ip:{}, 请求参数:{}", request.getRemoteAddr(), JSON.toJSONString(params));
        Integer id = (Integer) params.getOrDefault("id", 1);
        return ImmutableMap.of("id", id, "name", "xiaoming", "age", 19);
    }

}
