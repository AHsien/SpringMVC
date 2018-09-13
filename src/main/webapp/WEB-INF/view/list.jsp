<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 
	SpringMVC 處理靜態資源:
	1. 優雅的 REST 風格資源 URL 不希望帶有 .html 或 .do 等後綴
	   若將 DispatcherServlet 請求映射配置為 /，則 SpringMVC 將捕獲 WEB 容器的所有請求，
	   包括靜態資源的請求，SpringMVC 會將他們當成一個普通請求處理，因此找不到對應處理器將導致錯誤。
	2. 解決: 在 SpringMVC 的配置文件中配置 <mvc:default-servlet-handler/>
	
 -->
<script src="libraries/jquery-3.2.1.min.js"></script>
<script>
	$(function() {
		$(".delete").click(function(){
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();
			return false;
		})
	})
</script>
</head>
<body>

	<form action=""	method="post">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>

	<c:if test="${empty requestScope.employees }">
		沒有任何員工信息。
	</c:if>
	<c:if test="${!empty requestScope.employees }">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<c:forEach var="emp" items="${requestScope.employees }">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.gender == 0 ? "Female" : "Male" }</td>
					<td>${emp.department.departmentName }</td>
					<td><a href="emp/${emp.id }">Edit</a></td>
					<td><a class="delete" href="emp/${emp.id }">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<br/><br/>
	
	<a href="emp">Add New Employee</a>
</body>
</html>