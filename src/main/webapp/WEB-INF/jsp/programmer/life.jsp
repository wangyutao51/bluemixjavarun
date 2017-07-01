<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
<title>程序员的自我修养</title>
</head>
<body>
	<div style="margin-left: 50px;">
		<h1>程序员的一天</h1>
		<div id="words" style="width: 400px;height: 150px">
			${words}
		</div>
		<br>
		<button id="changewords" type="button" class="btn btn-primary"  value="程序员的自我修养" style="margin-left: 50px;">程序员的自我修养</button>
	</div>
<script type="text/javascript" src="../resource/programmer/js/jquery.min.js"></script>
<script type="text/javascript" src="../resource/programmer/js/changeWords.js"></script>
<script src="../resource/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>