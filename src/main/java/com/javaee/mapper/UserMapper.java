package com.javaee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaee.po.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {


}
