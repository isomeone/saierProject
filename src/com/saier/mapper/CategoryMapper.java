package com.saier.mapper;

import java.util.List;

import com.saier.pojo.Category;
import com.saier.util.Page;

public interface CategoryMapper {

	public int add(Category category);

	public void delete(int id);

	public Category get(int id);

	public int update(Category category);

	public List<Category> list();

	public List<Category> list(Page page);

	public List<Category> listByName(Category category);

	public int total(Category category);

	public int upload(Category category);

}