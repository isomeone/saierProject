package com.saier.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.saier.pojo.Category;
import com.saier.service.CategoryService;
import com.saier.util.Base64;
import com.saier.util.Page;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/index")
	public ModelAndView show() {
		ModelAndView mav = new ModelAndView("/index");
		return mav;
	}

	@RequestMapping("listByName")
	public ModelAndView listByName(Category category) {

		ModelAndView mav = new ModelAndView();
		List<Category> cs = categoryService.listByName(category);
		int total = categoryService.total(category);
		Page page = new Page();
		page.caculateLast(total);

		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategory");
		return mav;
	}

	@RequestMapping("listCategory")
	public ModelAndView listCategory(Page page) {

		ModelAndView mav = new ModelAndView();
		List<Category> cs = categoryService.list(page);
		Category cat = new Category();
		cat.setName("");
		int total = categoryService.total(cat);

		page.caculateLast(total);

		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategory");
		return mav;
	}

	@RequestMapping("addCategory")
	public ModelAndView addCategory(Category category) {
		categoryService.add(category);
		ModelAndView mav = new ModelAndView("redirect:/listCategory");
		return mav;
	}

	@RequestMapping("deleteCategory")
	public ModelAndView deleteCategory(Category category) {
		categoryService.delete(category);
		ModelAndView mav = new ModelAndView("redirect:/listCategory");
		return mav;
	}

	@RequestMapping("editCategory")
	public ModelAndView editCategory(Category category) {
		Category c = categoryService.get(category.getId());
		ModelAndView mav = new ModelAndView("editCategory");
		mav.addObject("c", c);
		return mav;
	}

	@RequestMapping("updateCategory")
	public ModelAndView updateCategory(Category category) {
		categoryService.update(category);
		ModelAndView mav = new ModelAndView("redirect:/listCategory");
		return mav;
	}

	@RequestMapping("uploadImage")
	public ModelAndView uploadFile(HttpServletRequest request, Category category)
			throws IllegalStateException, IOException {
		String fileName = category.getFileInput().getOriginalFilename();
		String name = RandomStringUtils.randomAlphanumeric(10);
		String newFileName = name + fileName;
		String realPath = request.getServletContext().getRealPath("/image");
		File newFile = new File(realPath, newFileName);
		newFile.getParentFile().mkdirs();
		category.getFileInput().transferTo(newFile);
		String codeFile = Base64.byteConverterBASE64(newFile);
		category.setCodeFile(codeFile);
		category.setName(newFileName);
		categoryService.upload(category);
		ModelAndView mav = new ModelAndView("redirect:/listCategory");
		return mav;
	}

}
