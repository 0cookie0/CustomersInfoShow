package com.javaee.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaee.mapper.CustomerMapper;
import com.javaee.po.Customer;
import com.javaee.service.ICustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper,Customer> implements ICustomerService {
}
