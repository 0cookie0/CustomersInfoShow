package com.javaee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaee.po.User;


public interface IUserService extends IService<User> {

    IPage<User> getPage(int currentPage,int pageSize);

    Boolean login(User user);
}
