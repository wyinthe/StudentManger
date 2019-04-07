 $(function(){
	 $("#upButton").click(function(){

		    var name = $("#stuName").val();
			var birthday = $("#stuBirthday").val();
			var age = $("#stuAge").val();
			var score = $("#stuScore").val();
			var classId = $("#stuClassId").val();
			var address = $("#stuAddress").val();
			 var id = $("#stuId").val();


			if(name == null || name ==""){
				alert("名前を入力してくだ");
				return false;
			}else{
				var inputname =/^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
				if(!inputname.test(name)){
					alert("名前をcheckしてくだ");
					return false;
				}else{
					if(birthday == null || birthday ==""){
						alert("生年月日を入力してくだ");
						return false;
					}else{
						var inputbirthday =/^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
						if(!inputbirthday.test($("#stuBirthday").val())){
							alert("生年月日をcheckしてくだ");
							return false;
					}else{
						if(age == null || age ==""){
							alert("年齢を入力してくだ");
							return false;
						}else{
							var inputage =/^[0-9]+$/;
							if(!inputage.test($("#stuAge").val())){
								alert("年齢をcheckしてくだ");
								return false;
							}else{
								if(score == null || score==""){
									alert("成績を入力してくだ")
									return false;
								}else{
									var inputscore =/^(([^0][0-9]+|0)\.([0-9]{1,2})$)|^(([^0][0-9]+|0)$)|^(([1-9]+)\.([0-9]{1,2})$)|^(([1-9]+)$)/;
									if(!inputscore.test($("#stuScore").val())){
										alert("成績をcheckしてくだ")
										return false;
									}else{
										if(classId == null || classId ==""){
											alert("クラスを入力してくだ");
											return false;
										}else{
											var inputclassId =/^[0-9]+$/;
											if(!inputclassId.test($("#stuClassId").val())){
												alert("クラスをcheckしてくだ");
												return false;
											}else{
												if(address ==null || address ==""){
													alert("住所を入力してくだ");
													return false;
												}else{
													var inputaddress =/^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
													if(!inputaddress.test($("#stuAddress").val())){
														alert("住所をcheckしてくだ");
														return false;
													}else{
														if(id ==null || id ==""){
															alert("IDを入力してくだ");
															return false;
														}else{
															var inputid =/^[0-9]+$/;
															if(!inputid.test($("#stuId").val())){
																alert("IDをcheckしてくだ");
																return false;
															}else{
																alert("追加完了");
																$("#upstudent").submit();
															}
														}

													}
												}
											}


										}
									}
								}

							}
						}

					}

					}

				}
			}

	 })
 })