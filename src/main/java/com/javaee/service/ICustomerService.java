package com.javaee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javaee.po.Customer;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICustomerService extends IService<Customer> {

}
