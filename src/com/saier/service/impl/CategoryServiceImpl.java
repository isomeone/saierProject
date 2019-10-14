package com.saier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saier.mapper.CategoryMapper;
import com.saier.pojo.Category;
import com.saier.service.CategoryService;
import com.saier.util.Page;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryMapper categoryMapper;

	public List<Category> list() {
		return categoryMapper.list();
	}

	@Override
	public List<Category> list(Page page) {
		// TODO Auto-generated method stub
		return categoryMapper.list(page);
	}

	@Override
	public List<Category> listByName(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.listByName(category);
	};

	@Override
	public int total(Category category) {
		return categoryMapper.total(category);
	}

	@Override
	public void add(Category c) {
		categoryMapper.add(c);

	}

	@Override
	public void update(Category c) {
		categoryMapper.update(c);
	}

	@Override
	public void delete(Category c) {
		categoryMapper.delete(c.getId());
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.get(id);
	}

	@Override
	public void upload(Category c) {
		// TODO Auto-generated method stub
		categoryMapper.upload(c);
	}

}
