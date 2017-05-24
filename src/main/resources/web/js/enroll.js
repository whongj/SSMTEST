
$(function(){
    $(".pas").css("display","none");
	$("#btn-2").css("display","none");
    $("#btn-1").on("click",function(){
		console.log($("#enroll-tel").val());
		//$.post("enroll.html",{
		//	tel: $("#enroll-tel").val(),
		//	code: $("#enroll-code").val()
		//},function(data,textStatus){
		//	$(".weui-cells").css("display","none");
		//	$("#btn-1").css("display","none");
		//	$("#btn-2").css("display","block");
		//	$(".pas").css("display","block");
		//});
		$.ajax({
			type: "POST",
			dataType: "json",
			data: "&tel="+$("#enroll-tel").val()+"&code="+$("#enroll-code").val(),
			success: function(){
				$(".weui-cells").css("display","none");
				$("#btn-1").css("display","none");
				$("#btn-2").css("display","block");
				$(".pas").css("display","block");
				alert("success");
			},
			callback: function(){
				alert("载入成功");
			},
			error: function(){
				alert("请求异常");
			}
		});
    });
	$("#btn-2").on("click",function(){
		var pas_start = $("#pas-start").val();
		var pas_again = $("#pas-again").val();
		if(pas_start == pas_again){
			$.post("enroll.html",function(){
				password: $("#pas-start").val()
			});
		}
		else{
			alert("输入密码不一致");
		}
	});
})
