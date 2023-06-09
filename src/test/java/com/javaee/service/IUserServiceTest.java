package com.javaee.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javaee.mapper.UserMapper;
import com.javaee.po.User;
import com.javaee.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IUserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    void testGetById(){
        System.out.println(userService.getById(1));
    }
    @Test
    void testSave(){
        User user = new User();
        user.setUsername("testMybatisPlus");
        user.setPassword("21212");
        userService.save(user);
    }
    @Test
    void testUpdate(){
        User user = new User();
        user.setId(25);
        user.setUsername("test");
        user.setPassword("MybatisPlus-Service");
        userService.updateById(user);
    }

    @Test
    void testDelete(){
        userService.removeById(28);
    }

    @Test
    void testGetAll(){
        System.out.println(userService.list());
    }
    @Test
    void testGetPage(){
        Page<User> page = new Page<User>(1,5);
        Page<User> page1 = userService.page(page);
        /*当前页*/
        System.out.println(page1.getCurrent());
        /*一共几页*/
        System.out.println(page1.getPages());
        /*数据*/
        System.out.println(page1.getRecords());
        System.out.println(page1.getSize());
        System.out.println(page1.getTotal());
    }

}
