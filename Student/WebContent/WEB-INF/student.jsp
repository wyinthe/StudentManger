<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html lang="en">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="add_comm" class="all" align="left">
		<h2>学生一覧をCsv出力</h2>
		<form action="getOutPutToCsv" method="post">
			<input type="text" placeholder="ファイル名" name="name"> <input
				type="submit" value="Csv出力">
		</form>
	</div>



	<div>

		<table border="2">

			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>birthday</th>
				<th>年龄</th>
				<th>成绩</th>
				<th>class</th>
				<th>住所</th>
			</tr>

			<!--  获取studencontroller层的循环内容   student类     -->
			<c:forEach items="${stuList}" var="student">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.birthday}</td>
					<td>${student.age}</td>
					<td>${student.score}</td>
					<td>${student.classId}</td>
					<td>${student.address}</td>
				</tr>
			</c:forEach>



		</table>
	</div>
	<br>
	<br>
	<br>
	<hr>
<a href="login.jsp" align="center">返回主页</a>


</body>
</html>