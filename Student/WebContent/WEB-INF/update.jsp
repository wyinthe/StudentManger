<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 郵便番号から住所を自動入力してくれるライブラリ -->
<script src="https://ajaxzip3.github.io/ajaxzip3.js"></script>

<script type="text/javascript" src="./js/jquery-3.3.1.js">

</script>
<script type="text/javascript" src="./js/update.js">

</script>
</head>
<body>

	<h1>学生の情報を更新</h1>


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
	    <h3>学生の情報を更新</h3>
        <form id="upstudent" action="updateStudent" method="post">
        <span>新しい情報を入力してください</span><br>
<input id="stuName" type="text" name="name" placeholder="名前を入力してください" />
<br>
<input id="stuBirthday" type="text" name="birthday" placeholder="生年月日を入力してください" />
<br>
<input id="stuAge" type="text" name="age" placeholder="年齢を入力してください" />
<br>
<input id="stuScore" type="text" name="score" placeholder="成績を入力してください" />
<br>
<input id="stuClassId" type="text" name="classId" placeholder="クラスを入力してください" />
<br>
<input id="stuAddress" type="text" name="address" placeholder="住所を入力してください" />
<br>
<br>
<!--文本标签  -->
<span>更新用の学生のIDを入力してください</span><br>
<input id="stuId" type="text" name="id" placeholder="IDを入力してください" />
<br>
<br>
<input id="upButton" type="submit" value="確認"/>

</form>
	</div>
<br>


     <div>
            <h3>郵便番号で住所を追加する</h3>
         <form id="addAddress" action="addStduentAddress" method="post">
                  <label>郵便番号(ハイフンもOK)</label>
              <br>
                  <input type="text" name="zip11" size="10" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this,'','addr11','addr11');">
              <br>
                  <label>都道府県と以降の住所</label>
              <br>
                   <input type="text" name="addr11" size="60">
              <br>
                   <span>更新用の学生のIDを入力してください</span>
              <br>
                   <input id="stuId" type="text" name="id" placeholder="IDを入力してください">
              <br>
                   <input id="addButton" type="submit" value="確認" />
         </form>

     </div>






	</body>
</html>