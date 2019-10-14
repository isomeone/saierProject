<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="width: 800px; margin: 0px auto; text-align: center">
	<table align='center' border='1' cellspacing='0'>
		<tr>
			<td>图片编号</td>
			<td>图片名称</td>
			<td>图片</td>
			<td>编辑</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${cs}" var="c" varStatus="st">
			<tr>
				<td>${c.id}</td>
				<td>${c.name}</td>
				<td><img src="data:image/jpeg;base64,${c.codeFile}" height="125" width="120"></td>
				<td><a href="editCategory?id=${c.id}">编辑</a></td>
				<td><a href="deleteCategory?id=${c.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<div style="text-align: center">
		<a href="?start=0">首 页</a> <a href="?start=${page.start-page.count}">上一页</a>
		<a href="?start=${page.start+page.count}">下一页</a> <a
			href="?start=${page.last}">末 页</a>
	</div>


	<div style="text-align: center; margin-top: 40px">

<!-- 		<form method="post" action="addCategory"> -->
<!-- 			分类名称： <input name="name" value="" type="text"> <br> <br> -->
<!-- 			<input type="submit" value="修改名称"> -->
<!-- 		</form> -->

		<form method="post" action="uploadImage" enctype="multipart/form-data">
			<input type="file" name="fileInput" width="120px" accept="image/*"> 
			<input type="submit" value="上传">
		</form>
	</div>
</div>
