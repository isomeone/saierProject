package com.saier.pojo;

import org.springframework.web.multipart.MultipartFile;

public class Category {
	private int id;
	private String name;
	private MultipartFile fileInput;
	private String codeFile;
	
	
	public String getCodeFile() {
		return codeFile;
	}
	public void setCodeFile(String codeFile) {
		this.codeFile = codeFile;
	}
	public MultipartFile getFileInput() {
		return fileInput;
	}
	public void setFileInput(MultipartFile fileInput) {
		this.fileInput = fileInput;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
