
$(function(){
	// 添加一个点击事件 .click
	// 更具标签的id属性来选择提交按钮，选中之后给他添加点击事件，每当点击按钮时，执行括号内的函数代码，发起检查
	$("#delButton").click(function(){
		// 获取输入框输入的内容
		var studentId = $("#stuId").val();
		// 去除前后空格
		studentId = $.trim(studentId);
		// 对输入内容进行检查
		// 如果输入框的内容为null或者空值，·1
		if (studentId == null || studentId == "") {
			// 给用户一个弹框提示
			alert("IDを入力してください");
			// 设定返回值为false，取消档次请求的提交
			return false;

		} else {
			// 如果输入的内容不为空，则执行下列代码进行检查
			// 引用正则表达式，对输入内容进行限定
			var putid = /^[0-9]+$/; // 整数正则表达式
			// 如果将获取到的输入内容studentId赋值给putId的test文本内容时，putId与原先的整数型数字类型限定不一致时
			if (!putid.test($("#stuId").val())) {
				// 给用户一个弹框提示
				alert("查无此ID");
				// 设定返回值为false，取消档次请求提交
				return false;
			} else {
				// 如果获取到的内容既不为空，同时又符合正则表达式限定的整数型数字时
				// 给用户一个弹窗提示
				alert("ID消除成功");
				// 获取id名称为gotoSelect的标签，添加 .submit（提交）事件，提交本次根据id查询的请求到服务器进行查询
				$("#delById").submit();
			}
		}

	})


	/**
	 * 1 学生名字检查
	 */
	$("#delNameButton")
			.click(
					function() {
						var inputName = $("#stuName").val();
						inputName = $.trim(inputName);

						if (inputName == null || inputName == "") {
							alert("名前を入力してください");
							return false;
						} else {
							var checkName = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
							if (!checkName.test($("#stuName").val())) {
								alert("名前をチェックしてください")
								return false;
							} else {
								alert("删除成功")
								$("#deleteByName").submit();

							}

						}

					})







})