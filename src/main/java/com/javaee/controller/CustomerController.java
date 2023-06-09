package com.javaee.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.javaee.controller.utils.Result;
import com.javaee.po.Customer;
import com.javaee.service.ICustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public Result getAll(){
        return new Result(true,customerService.list());
    }

    @GetMapping("getAllByName")
    public Result getAllByName(@RequestParam String name){
        /*当前段没有输入数据时,默认传过来是空字符串,不是null,即查询所有*/
        LambdaQueryWrapper<Customer> qw = new LambdaQueryWrapper<>();
        qw.like(name != null,Customer::getName,name);
        return new Result(true,customerService.list(qw));
    }
    @PostMapping("deleteGroup")
    public Result deleteGroup(@RequestBody List<Customer> customers){
        return new Result(customerService.removeBatchByIds(customers));
    }

    @PostMapping
    public Result addCustomer(@RequestBody Customer customer){
        return new Result(customerService.save(customer));
    }
    //TODO 编辑,删除,还有注册业务

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        return new Result(customerService.removeById(id));
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id){
        return new Result(true,customerService.getById(id));
    }

}
