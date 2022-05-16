package com.wangye.hello.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangye.hello.entity.User;
import com.wangye.hello.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangye
 * @version v1.0
 * @apiNode 用户接口
 * @date : 2022-5-16 18:20
 */
@RestController
public class HelloController {

    @Resource
    UserMapper userMapper;

    @GetMapping("/")
    public String Hello() throws JsonProcessingException {
        List<User> users =  userMapper.getAll();
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(users);
        return str;
    }
}
