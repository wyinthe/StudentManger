<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html lang="en">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript">
$(function(){
	/*
	入力チェック
	1.手动提交时的检查
	2.通过键盘的回车键提交
	*/
	$("#findButton").click(function(){
		var pageNo = $("#findPageNo").val();
		if (pageNo==null ||pageNo==""){
			alert("请输入要跳转的页码");
			return false;
		}else{
			var inputNo = /^[0-9]+$/;
			if(!inputNo.test(pageNo)){
				alert("请输入数字");
				return false;
			}else{
				$("#findpage").submit();

			}
		}

	});


	$("#page").keydown(function(){
		if(event.keyCode == "13"){

			var pageNo = $("#findPageNo").val();
			if(pageNo == null || pageNo == ""){
				alert("请输入要跳转的页码");
				return false;
			}else{
				var inputNo = /^[0-9]+$/;
				if(!inputNo.test(pageNo)){
					alert("请输入数字");
					return false;
				}else{
					$("#findpage").submit();
				}
			}

		}
	})



	/*
	首页 上一页，下一页，末页的隐藏
	*/
	//创建函数，通过Id选择器获取隐藏的input入力框中的当前页页码；
	var pageNO = $("#toPref").val();
	//创建函数，通过Id选择器获取隐藏的input入力框中的总页数；
	var allpage = $("#toLost").val();
	//当当前页为1时，即为首页，则不需要 首页 和 上一页 按钮
	if(pageNO == 1){
		$("#first,#prev").hide();

	}
	//当当前页为总页数时，即为末页，则不需要 末页 和 下一页 按钮
	if(pageNO == allpage){
		$("#next,#lost").hide();

	}



});
</script>
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


<br>
<br>
<br>
<h1>学生一覧のTablle</h1>
	<div id="tab">


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
	<!-- 分页功能模块 -->
	<div id="page">
	<!-- 页码显示模块 -->
	<div id="pageMessage">
	      <span>共${totalPage}页</span>,<span>当前第${pageNum}页</span>
	</div>
	<!-- 首页功能模块 -->
	<div id="first">
	<form id="firstpage" action="goTOStudentPage" method="post">
	<input id="firstButton" type="submit" value="首页">
	</form>
	</div>

	<!-- 上一页功能模块 -->
	<div id="prev">
	<form id="prevpage" action="getStudentPrevPage" method="post">
	<!-- 做一个隐藏的入力框，将页面的页码设置成属性值后，可以通过name属性，将页码传递到控制层
        同时可以在写js代码时，根据获得的当前页来判断，如果当前页是第一页，即可将 首页 上一页按钮隐藏
	 -->
	<input id="toPref" type="hidden" value="${pageNum}" name="jspPrevPage">
	<!-- 在js代码中，获取总页数，来判断是非隐藏 下一页 末页的按钮 -->
	<input id="toLost" type="hidden" value="${totalPage}" name="jspLostfPage">
	<input id="prevButton" type="submit" value="上一页">
	</form>
	</div>

    <!-- 下一页功能模块 -->
    <div id="next">
	<form id="nextpage" action="getStudentNextPage" method="post">
	<input id="toNext" type="hidden" value="${pageNum}" name="jspNextfPage">
	<input id="nextButton" type="submit" value="下一页">
	</form>
	</div>

    <!-- 末页功能模块 -->
    <div id="lost">
	<form id="lostpage" action="getStudentLostPage" method="post">
	<input id="lostButton" type="submit" value="末页">
	</form>
	</div>

    <!-- 跳转功能模块 -->
    <div id="find">
	<form id="findpage" action="getStudentFindPage" method="post">
	<span>跳转到<input id="findPageNo" type="text" name="pogeNo" size="2" /></span>
	<input id="findButton" type="submit" value="确定" />
	</form>
	</div>




	</div>

	<br>
	<br>
	<br>
	<hr>
<a href="login.jsp" align="center">返回主页</a>


</body>
</html>