package com.saier.service;

import java.util.List;

import com.saier.pojo.Category;
import com.saier.util.Page;

public interface CategoryService {

	List<Category> list();

	int total(Category category);

	List<Category> list(Page page);

	List<Category> listByName(Category category);

	void add(Category c);

	void update(Category c);

	void delete(Category c);

	Category get(int id);

	void upload(Category c);
}
