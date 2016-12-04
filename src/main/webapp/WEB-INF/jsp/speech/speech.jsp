<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>语音文字转换</title>
</head>
<body>
	<form action="export.do" method="post">
		<span>请输入要转换为语音的英文，语义分割不需要标点符号</span>
		<br>
		<textarea rows="5" cols="50" name="text"></textarea>
		<br>
		<input type="submit" value="提交">
	</form>
</body>
</html>