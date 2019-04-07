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
<script type="text/javascript" src="./js/select.js">

</script>
</head>





<body>
<h3>增加老师信息</h3>


	<div>

		<table border="2">

			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>birthday</th>
				<th>年龄</th>
				<th>成绩</th>
				<th>住所</th>
				<th>班级</th>

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
					<td>${teacher.classid}</td>
				</tr>
			</c:forEach>



		</table>
	</div>
	<br>
	<br>




	<div>
	<form id="addTea" action="addTeacher" method="post">
    <input id="TeaName" type="text" name="name" placeholder="名前を入力してください">
    <br>
           <input id="TeaBirthday" type="text" name="birthday" placeholder="生年月日を入力してください">
      <br>
          <input id="TeaAge" type="text" name="age" placeholder="年齢を入力してください">
     <br>
          <input id="TeaScore" type="text" name="score" placeholder="成績を入力してください">
      <br>
          <input id="TeaAddress" type="text" name="address" placeholder="住所を入力してください">
     <br>
          <input id="TeaClassId" type="text" name="classId" placeholder="クラスを入力してください">

     <br>
          <input id="addButton" type="submit" value="確認"/>
</form>


	</div>
	<br>
	<br>
	<br>
	<hr>
<a href="login.jsp" align="center">返回主页</a>


</body>

</html>