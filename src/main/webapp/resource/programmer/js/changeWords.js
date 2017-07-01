$("#changewords").click(function(){
	$.ajax({
		type: "POST", //提交的类型
		url: "words.do",//提交地址
		data: null,//参数
		success: function(msg){ //回调方法
			//alert(msg.words);
			$("#words").empty();
			$("#words").html(msg.words);
		}
		});
  });