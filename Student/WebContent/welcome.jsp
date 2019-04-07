<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- style css可以用来修改字体与其他 -->
<style type="text/css">
/*
   #号根据id选择标签
   css里面选择器 diy用-->
   根据class属性选择标签
   .class{}
   div{}
*/
#box1{
background-color:green;
width: 300px;
height:200px;
float:Left;
}

#box2{
background-color:blue;
width: 300px;
height:200px;
float:Left;
}

#box3{
background-color:pink;
width: 300px;
height:200px;
float:Left;
}
</style>

<title>Insert title here</title>
</head>
<body>
<!-- 显示主页内容的文字 超链接等都写在body里面 （div标签）-->
<div id="box1">
<!-- id唯一性   class分组多选能选择class里面的全部   <a开始定义超链接  -->
<a id="Link1" class="box1" href="https://start.firefoxchina.cn/">
<font color="red">google查询</font>
<br>
<br>



<img src=”image.png” alt="猫の写真" title="可愛い猫">
<div class="center">
インライン要素
</div>
.center{
border: 1px solid #aaa;
width: 400px;
text-align: center;
}














</a>


</div>

<div id="box2">
<!-- 可在 < 前输入信息input内容标签 添加框和框的大小 初始值虚影的用placeholder-->
名前:<input id="pt1" type="text" size="15" placeholder="hello"/>
sports<br>
<input id="pt2" type="checkbox" value="sports"/>
<br>
<input id="pt3" type="radio"/>
<input id="pt4" type="password"/>
<!-- 点击后直接能提交上去 -->
<input id="pt5" type="submit" value="確認"/>
</div>
<!-- 这种按钮需要关联其他才能使用 -->
<button><font color="red">確認</font></button>

<div id="box3">

</div>
<body>
<div id="box3">
<h1> Hello world </h1>
<h2>Hello world</h2>
<h3>Hello world</h3>
<h4>Hello world</h4>
<h5>Hello world</h5>
<h6>Hello world</h6>
</div>
</body>

</body>
</html>