package com.saier.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.saier.mapper.CategoryMapper;
import com.saier.pojo.Category;
import com.saier.util.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	private CategoryMapper categoryMapper;

//	@Test
//	public void testAdd() {
//		for (int i = 0; i < 100; i++) {
//			Category category = new Category();
//			category.setName("new Category");
//			categoryMapper.add(category);
//		}
//
//	}
//	
	@Test
	public void testTotal() {
		Category cat=new Category();
		cat.setName("9e9bb");
		int total = categoryMapper.total(cat);
		System.out.println(total);
	}

//	@Test
//	public void testList() {
//		Page p = new Page();
//		p.setStart(2);
//		p.setCount(3);
//		List<Category> cs=categoryMapper.list(p);
//		for (Category c : cs) {
//			System.out.println(c.getName());
//		}
//	}

}
