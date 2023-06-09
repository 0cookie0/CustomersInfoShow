package com.javaee.controller;


import com.javaee.controller.utils.Result;
import com.javaee.po.User;
import com.javaee.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public Result getAll(){

        return new Result(true,userService.list());
    }

    @PostMapping
    /*传过来是json格式*/
    public Result save(@RequestBody User user){
        return new Result(userService.save(user)) ;
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        return new Result(userService.removeById(id));
    }

    @PutMapping
    public Result update(@RequestBody User user){
        return new Result(userService.updateById(user)) ;
    }

    @GetMapping("{id}")
    /*对应url为/user/1*/
    public Result getById(@PathVariable Integer id){
        return new Result(true,userService.getById(id)) ;
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return new Result(true,userService.getPage(currentPage, pageSize)) ;
    }

    @PostMapping("login")
    public Result login(@RequestBody User user){
        return new Result(userService.login(user));
    }




}
