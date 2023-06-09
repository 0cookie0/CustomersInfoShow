package com.javaee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaee.po.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
