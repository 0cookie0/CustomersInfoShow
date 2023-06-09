package com.javaee;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javaee.mapper.UserMapper;
import com.javaee.po.User;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.SocketTimeoutException;
import java.util.List;

@SpringBootTest
class SpringsoottemplateApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	void selectById() {
		System.out.println(userMapper.selectById(1));
	}

	@Test
	void testSave(){
		User user = new User();
		user.setPassword("2266655");
		user.setUsername("测试mybatis-plus");
		int insert = userMapper.insert(user);
		System.out.println(insert);
	}
	@Test
	void testUpdate(){
		User user = new User();
		user.setId(29);
		user.setPassword("2266655");
		user.setUsername("测试mybatis-plus Upda");
		int update = userMapper.updateById(user);
		System.out.println(update);
	}
	@Test
	void testDelete(){
		int i = userMapper.deleteById(29);
		System.out.println(i);
	}

	@Test
	void testGetAll(){
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}

	@Test
	void testGetPage(){
		Page page = new Page(1,5);
		/*此功能需要依赖MPConfig,需要注进去一个拦截器的bean*/
		Page page1 = userMapper.selectPage(page, null);
		System.out.println(page1);
		/*当前页*/
		System.out.println(page1.getCurrent());
		/*一共几页*/
		System.out.println(page1.getPages());
		/*数据*/
		System.out.println(page1.getRecords());
		System.out.println(page1.getSize());
		System.out.println(page1.getTotal());

	}

	@Test
	void testGetBy(){
		/*按条件查询需要传入条件*/
		QueryWrapper<User> qw = new QueryWrapper<User>();
		/*把条件查询做成API形式*/
		qw.like("username","Cookie");
		List<User> users = userMapper.selectList(qw);
		System.out.println(users);
	}
	@Test
	void testGetBy2(){
		/*按条件查询需要传入条件*/
		LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
		/*需要先判断模糊查询参数是否为null*/
		String name = null;
		/*添加上条件判断,如果name为空,则不连接模糊查询条件,即查询所有*/
		lqw.like(name != null,User::getUsername,"Cookie");

		userMapper.selectList(lqw);
	}

	@Test
	void login() {
		User user = new User();
		user.setUsername("Cookie");
		user.setPassword("12345");
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username",user.getUsername());
		queryWrapper.eq("password",user.getPassword());
		System.out.println(userMapper.selectOne(queryWrapper));
	}

}
