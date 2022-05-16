package com.wangye.hello;

import com.wangye.hello.entity.User;
import com.wangye.hello.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HelloApplicationTests {
    //继承了BaseMapper所有的方法，可以编写自己的扩展方法
    @Autowired
    private UserMapper UserMapper;

    @Test
    public void testSelect() {
        System.out.println("--------selectAll method test-------");
        //查询全部用户，参数是一个Wrapper，条件构造器，先不使用为null
        List<User> userList = UserMapper.getAll();
        userList.forEach(System.out::println);
    }

    //测试插入
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("小文");
        user.setAge(21);
        user.setEmail("2312103645@qq.com");

        int insert = UserMapper.insert(user);//如果没有设置id，那么会自动生成id
        System.out.println(insert);//受影响行数
        System.out.println(user);//id会自动回填
    }
}