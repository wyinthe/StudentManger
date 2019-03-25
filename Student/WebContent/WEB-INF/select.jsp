<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" scr="./js/jquery-3.3.1.js">  </script>
<script type="text/javascript" scr="./js/select.js">

   //这个$(function 是jquery的最外层页面信息
$(function(){
	//添加一个点击事件 .click
	//更具标签的id属性来选择提交按钮，选中之后给他添加点击事件，每当点击按钮时，执行括号内的函数代码，发起检查
	$("#selbutton").click(function(){
		//获取输入框输入的内容
		var studentId = $("#selId").val;
		//去除前后空格
		studentId = $.trim(studentId);
		//对输入内容进行检查
		//如果输入框的内容为null或者空值，
		if(studentId == null || studentId == ""){
			//给用户一个弹框提示
			alter("IDを入力してください");
			//设定返回值为false，取消档次请求的提交
			return false;

		}else{
			//如果输入的内容不为空，则执行下列代码进行检查
			//引用正则表达式，对输入内容进行限定
			var putid = /^[1-9]+$/;      //整数正则表达式
			//如果将获取到的输入内容studentId赋值给putid的test文本内容时，putid与原先的整数型数字类型限定不一致时

		if(!putid.test(studentId)){
				//给用户一个弹框提示
				alter("请检查ID");
				//设定返回值为false，取消档次请求提交
				return false;
			}else{
				//如果获取到的内容既不为空，同时又符合正则表达式限定的整数型数字时
				//给用户一个弹窗提示
				alert("ok");
				//获取id名称为gotoSelect的标签，添加  .submit（提交）事件，提交本次根据id查询的请求到服务器进行查询
				$("#gotoSelect").submit();
			}
		}

	});





})

</script>
</head>

<body>
<h1>学生の情報管理</h1>
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
	<div>
	<h3>IDで学生の情報を探す</h3>
	<form id="gotoSelect" action="selStudent" method="post">
	<input id="selId" type="text" placeholder="IDを入力してください" name="id" />
	<input id="selbutton" type="submit" value="確認" />

	</form>

	</div>


	<br>

	<div>
	<h3>ID查询</h3>
	 <form id="getID" action="getStudentById" method="post">
	 <input id="student" type="text" name="id" placeholder="请输入学生的id">
	 <input id="queryId" type="submit" value="确认">
	 </form>


	</div>


	<div>
	<h3>name查询</h3>
	 <form id="getname" action="getStudentByName" method="post">
	 <input id="student" type="text" name="name" placeholder="请输入学生的name">
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