<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html lang="en">
<head>
<script type="text/javascript" src="./js/jquery-3.3.1.js">
</script>
<script type="text/javascript" src="./js/addStudent.js">

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>学生の情報を追加</h3>
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

<br><br>
<br><br>

<div>
<h3>学生の情報を追加</h3>
<form id="addStu" action="addStudent" method="post">
    <input id="stuName" type="text" name="name" placeholder="名前を入力してください">
    <br>
           <input id="stuBirthday" type="text" name="birthday" placeholder="生年月日を入力してください">
      <br>
          <input id="stuAge" type="text" name="age" placeholder="年齢を入力してください">
     <br>
          <input id="stuScore" type="text" name="score" placeholder="成績を入力してください">
     <br>
          <input id="stuClassId" type="text" name="classId" placeholder="クラスを入力してください">
     <br>
          <input id="stuAddress" type="text" name="address" placeholder="住所を入力してください">
     <br>
          <input id="addButton" type="submit" value="確認"/>
</form>

</div>


</body>
</html>