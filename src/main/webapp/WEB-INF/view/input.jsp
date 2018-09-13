<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		1. 為什麼使用 form 標籤呢？
		   可以更快速的開發出表單頁面，而且可以更方便的進行表單值的回顯
		2. 注意:
		   可以通過 ModelAttribute 屬性指定綁定的模型屬性，若沒有指定屬性，
		   則默認從 requestScope 對象中讀取 command 的表單 bean，
		   如果該屬性值也不存在，則會發生錯誤。
	 -->

	<form:form action="${pageContext.request.contextPath }/emp" method="POST" modelAttribute="employee">
		<c:if test="${employee.id == null }">
			<!-- path 屬性對應 html 表單標籤的 name 屬性 -->
	 		LastName : <form:input path="lastName" />
		</c:if>
		<%-- 對於 _method 不能使用 form:hidden 標籤，因為 modelAttribute 對應的 bean 中沒有 -method 這個屬性 --%>
		<%-- <form:hidden path="_method" value="PUT" --%>
		<c:if test="${employee.id != null }">
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="PUT" />
		</c:if>
		
		<br />
	 	Email : <form:input path="email" />
		<br />
		<%
			Map<String, String> genders = new HashMap();
			genders.put("1", "Male");
			genders.put("0", "Female");
			
			request.setAttribute("genders", genders);
		%>
	 	Gender : <form:radiobuttons path="gender" items="${genders }" />
	 	<br/>
	 	Department : <form:select path="department.id" items="${departments }"
	 		itemLabel="departmentName" itemValue="id"></form:select>
	 	<br/>
	 	<input type="submit" value="Submit" />
	 	
	</form:form>
</body>
</html>