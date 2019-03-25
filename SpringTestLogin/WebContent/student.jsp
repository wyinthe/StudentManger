<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
//1.编写$(function(){}),能够在整个JSP页面代码加载完毕之后再执行大括号内的代码;

$(function(){
//2.通过jquery提供的选择器，来选择要添加事件的标签。本处，是用id选择器来选择id=query的标签。即页面中编写的button标签；
//2.1 给选择的标签添加click响应函数，
    $(#"query").click(function(){
 //3.创建一个变量input Id.用已接收 输入到文本框的信息；
var input_id = $(#"queryById").val();
 //4.进行逻辑判断;
//4.1首先进行非空判断，如果没有在文本框输入信息就点击提交按钮，给出弹框提示alert（"输入要查询的id")
   if(input_id　== null ||　input_Id== ""){
             alert( "输入要查询的id！！！!");

//4.2 此处的return false 用于取消原先的默许行为；
            return false;
            } else {
//5 如果有在文本框输入内容，则再对内容进行判断
//5.1 创建一个变量value,使用正则表达式，设定内容为整数型数字
           var value =/^[0-9]+$/;
// 5.2 如果获取的内容不是整数型数字，则给出弹窗提示alert("请输入正确的ID");
           if(!vvalue.test($("#queryById").val())){
           alert("请输入正确的ID");
           return false
           } else{

//6  如果即有输入的内容，格式又是整数型的，则提交内容，发起请求
     $("#queryId").subint();
     }











</script>









</head>
<body>

</body>
</html>