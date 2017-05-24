$(function(){
	var ary = [];
    $(".login_tel").css("display","none");
    $("#login_we_btn").on("click",function(){
        $(".login_we").css("display","none");
		$("#login_we_btn").css("display","none");
        $(".login_tel").css({display: "block"});
    });
    $("#login_click").on("click",function(){
		var data1 = $("#login_tel_number").val();
		var data2 = $("#login_tel_password").val();
		var json1 = {
				"phonenum":data1,
				"pwd":data2
			};
		console.log(JSON.stringify(json1));
		$.ajax({
			url:"/phonelogin",
			type: "POST",
			dataType: "json",
			contentType: "application/json",
			data: JSON.stringify(json1),
			success: function(data){
				console.log(data);
			},
			error: function(xhr,text){
				alert("请求异常");
				console.log(text);
			}
		});
    });
})
