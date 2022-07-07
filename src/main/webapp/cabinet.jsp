<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="css/bootstrap-utlities.css">
	<link rel="stylesheet" href="css/bootstrap-reboot.css">
	<link rel="stylesheet" href="css/bootstrap-grid.css">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/style.css">
	<title>Cabinet</title>
</head>
<body>
<c:import url="add/menu.jsp"/>

<div class="container c_corr">
	<div class="row">
		<div class="col-md-12">
			<center>
				<h2>Кабинет пользователя ${user.login}</h2>
			</center>
		</div>
	</div>
	<div class="row">
				
			<div class="col-md-3">
				<img src="image/user.png" class="img-fluid">
				<input form="userForm" type="file" class="form-control">
			</div>
			<div class="col-md-9">
				<form id="userForm" action="<c:url value="<%= AppConstant.EDIT_CONT %>"/>">
					<input type="text" name="<%= AppConstant.LOGIN_LABEL %>" value="${user.login}" class="form-control"><br>
					<input type="email" name="<%= AppConstant.EMAIL_LABEL %>" value="${user.email}" class="form-control"><br>
					<input type="submit" value="Изменить данные" class="btn btn-success">
				</form>
			</div>
		

	</div>
</div>

<c:import url="add/foot.jsp"/>
</body>
</html>