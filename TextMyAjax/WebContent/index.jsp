<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
    <jsp:directive.page language="java"
        contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />
    <jsp:text>
        <![CDATA[ <?xml version="1.0" encoding="ISO-8859-1" ?> ]]>
    </jsp:text>
    <jsp:text>
        <![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
    </jsp:text>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<SCRIPT type="text/javascript">

window.onload=function(){
	 // 1获取a节点 对其添加onclick函数
	 document.getElementsByTagName("a")[0].onclick=function(){
	 // 3创建一个XMLHttpRequest对象
	 var request = new XMLHttpRequest();
	 // 4准备发送求的数据 url
	 var url=this.href +"?time="+ new Date() ;
	 var method="GET";
	 //5 使用XMLHttpRequest对象的open方法
	 request.open(method,url)
	 //6使用XMLHttpRequest对象的send方法
	 request.send(null);
	 //7 为XMLHttpRequest对象添加onreadystatechange 响应函数
	request.onreadystatechange=function(){
	 //8判断响应是否完成   XMLHttpRequest对象的readysState属性值为4的时间候表示响应完成
		 if(request.readyState==4){
	 //9再判断响应是否可用:XMLhttpRequest对象的status属性为200
			 if(request.status==200||request.status==304){
	 //10 打印响应结果 responseText
			alert(request.responseText)
			 }
		 }
	 }
	 // 2取消a节点的默认行为
	 return false;
	 }
 }
</SCRIPT>
</head>
<body>

 <a href="HelloAjax.txt">HelloAjax </a>
</body>
</html>
</jsp:root>