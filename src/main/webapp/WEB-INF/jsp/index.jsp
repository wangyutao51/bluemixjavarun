<!DOCTYPE html>
<html>
<%
String path = request.getContextPath();  
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是http://localhost:8080/MyApp/）:  
String basePath = request.getScheme() + "://"  
        + request.getServerName() + ":" + request.getServerPort()  
        + path + "/";  
%>
<head>
	<title>Java Web Starter Application</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="style.css" />
	<script type="text/javascript">
	</script>
</head>
<body>
	<h1>This is my web test</h1>
	<table>
		<tr>
			<td style='width: 30%;'>
				<img class = "newappIcon" src='../images/newapp-icon.png'>
			</td>
			<td>
				<!-- The "Hello World!" message comes from /SimpleServlet -->
				<h1 id = "message"></h1>
				
				<p class='description'></p> Thanks for creating a <span class="blue">Liberty for Java Starter Application</span>.
			</td>
		</tr>
	</table>
	<!-- Call SimpleServlet to get the "Hello World" message  -->
	<script type="text/javascript" src="../js/index.js"></script>
</body>
</html>
