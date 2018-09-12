<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="springmvc/testPojo" method="post">
		User Name : <input type="text" name="userName" />
		<br/>
		Password : <input type="password" name="password" />
		<br/>
		Email : <input type="text" name="email" />
		<br/>
		Age : <input type="text" name="age" />
		<br/>
		City : <input type="text" name="address.city" />
		<br/>
		District : <input type="text" name="address.district" />
		<br/>
		<input type="submit" value="Submit"/>
	</form>

	
	<a href="springmvc/testCookieValue">Test @CookieValue</a>
	<br/><br/>

	<a href="springmvc/testRequestHeader">Test @RequestHeader</a>
	<br/><br/>

	<a href="springmvc/testRequestParam?user=darren&age=35">Test @RequestParam</a>
	<br/><br/>

	<form action="springmvc/testRest/1" method="POST">
		<input type="hidden" name="_method" value="PUT" />
		<input type="submit" value="TestRest PUT" />
	</form>
	<br/><br/>

	<form action="springmvc/testRest/1" method="POST">
		<input type="hidden" name="_method" value="DELETE" />
		<input type="submit" value="TestRest DELETE" />
	</form>
	<br/><br/>
	
	<form action="springmvc/testRest" method="POST">
		<input type="submit" value="TestRest POST" />
	</form>
	<br/><br/>

	<a href="springmvc/testRest/1">Test REST GET</a>
	<br/><br/>

	<a href="springmvc/testPathVariable/1">Test @PathVariable</a>
	<br/><br/>

	<a href="springmvc/testAntPath/abc/123">Test Ant Path</a>
	<br/><br/>

	<a href="springmvc/testParamsAndHeads?user=darren&age=12">Test ParamsAndHeads</a>
	<br/><br/>

	<form action="springmvc/testMethod" method="POST">
		<input type="submit" value="submit">
	</form>
	<br/><br/>

	<a href="springmvc/testMethod">Test RequestMapping Method</a>
	<br/><br/>
	
	<a href="springmvc/testRequestMapping">Test RequestMapping</a>
	<br/><br/>
	
	<a href="helloworld">Hello World</a>
</body>
</html>