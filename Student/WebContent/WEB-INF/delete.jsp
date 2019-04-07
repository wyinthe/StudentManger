<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="./js/jquery-3.3.1.js">

</script>
<script type="text/javascript" src="./js/delete.js">

</script>
</head>
<body>

	<h1>学生の情報を削除</h1>


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

	<div>
		<h3>IDで学生の情報を削除</h3>
		<form id="delById" action="DeleteStudent" method="post">
			<input id="stuId"  type="text" placeholder="学生のIDを入力してください" name="id" />
			<input id="delButton" type="submit" value="確認" />
		</form>
	</div>
<div>
		<h3>名前で学生の情報を削除</h3>
		<form id="deleteByName" action="goToDeleteByName" method="post">
			<input id="stuName" type="text" placeholder="名前を入力してください" name="name" />
			<input id="delNameButton" type="submit" value="確認" />
		</form>
	</div>


	<br>
	<br>
	<br>
	<hr>
	<a href="login.jsp" align="center">返回主页</a>


</body>
</html>