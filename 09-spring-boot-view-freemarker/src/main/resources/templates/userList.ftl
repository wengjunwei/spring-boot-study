<html>
	<head>
		<title>显示用户名称</title>
		<meta name="" content="" charset="utf-8"/>
	</head>
	<body>
		<table border="1"  align="center" width="50%">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
			</tr>
			<#list list as user >
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
				</tr>					
			</#list>
		</table>
	</body>
</html>