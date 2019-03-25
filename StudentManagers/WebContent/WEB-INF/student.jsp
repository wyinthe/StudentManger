<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="2">
<tr>
<th>编号</th>
<th>名字</th>
<th>生日</th>
<th>年龄</th>
<th>成绩</th>
<th>班级</th>
<th>住所</th>
</tr>

 <c:forEach items="${stuList}" var="student">

<tr>
<td>${student.id}</td>
<td>${student.name}</td>
<td>${student.birthday}</td>
<td>${student.age}</td>
<td>${student.score}</td>
<td>${student.classid}</td>
<td>${student.address}</td>


</tr>
 </c:forEach>


</table>

    <br>
	<br>
	<br>
	<hr>
          <a href="welcome.jsp" align="center">返回主页</a>

</body>
</html>