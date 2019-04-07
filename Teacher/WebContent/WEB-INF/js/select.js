//检查老师ID
$(function(){
	$("#queryId").click(function(){
		var teacherId = $("#teaId").val();



		if(teacherId ==null || teacherId == ""){
			alert("IDを入力してください")
			return false;
		}else{
			var inputId = /^[0-9]+$/;
			if(!inputId.test(teacherId)){
				alert("请检查ID");
				return false;
			}else{
				alert("ok");
				$("#getID").submit();

			}
		}



	});

	$("#queryname").click(function(){
		 var teacherName = $("#teaName").val();

		 if(teacherName == null || teacherName == ""){
			 alert("nameを入力してください")
				return false;
		 }else{
			 var inputteacherName = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
			 if(!inputteacherName.test(teacherName)){
				 alert("请检查name");
				 return false;

			 }else{
				 alert("ok");
					$("#getname").submit();




			 }
		 }


	})






})













