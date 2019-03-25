<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >


<html lang="en">
</head>

<body>
	<div>

		<table border="2">

			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>birthday</th>
				<th>年龄</th>
				<th>成绩</th>
				<th>住所</th>
			</tr>

			<!--  获取studencontroller层的循环内容   student类     -->
			<c:forEach items="${teaList}" var="teacher">
				<tr>
					<td>${teacher.id}</td>
					<td>${teacher.name}</td>
					<td>${teacher.birthday}</td>
					<td>${teacher.age}</td>
					<td>${teacher.score}</td>
					<td>${teacher.address}</td>
				</tr>
			</c:forEach>



		</table>
	</div>
	<br>
	<br>

	<div>
	<h3>ID查询</h3>
	 <form id="getID" action="getStudentById" method="post">
	 <input id="teacher" type="text" name="id" placeholder="请输入老师的id">
	 <input id="queryId" type="submit" value="确认">
	 </form>


	</div>


	<div>
	<h3>name查询</h3>
	 <form id="getname" action="getStudentByName" method="post">
	 <input id="teacher" type="text" name="name" placeholder="请输入老师的name">
	 <input id="queryname" type="submit" value="确认">
	 </form>


	</div>
	<br>
	<br>
	<br>
	<hr>
<a href="login.jsp" align="center">返回主页</a>


</body>

</html>