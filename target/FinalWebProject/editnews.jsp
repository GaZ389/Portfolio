<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="css/bootstrap-utilities.css">
	<link rel="stylesheet" href="css/bootstrap-reboot.css">
	<link rel="stylesheet" href="css/bootstrap-grid.css">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/style.css">
	<title>Edit news</title>
</head>
<body>
<c:import url="add/menu.jsp"/>

<div class="container c_corr">
	<div class="row">
		<div class="col-md-12">
			<center><h2>Редактировать новость</h2></center>
		</div>
	</div>
    <form method="post" action="<c:url value="<%= AppConstant.SAVE_NEWS_CONT %>"/>">
	    <div class="row">
			<div class="col-md-3">
				<img src="image/kybok.jpg" class="img-fluid">
				<input type="file" class="form-control">
			</div>
			<div class="col-md-9">
                <input type="hidden" value="${news.id}" name="<%= AppConstant.ID_LABEL %>">
				<input type="text" value="${news.title}" name="<%= AppConstant.TITLE_LABEL %>" class="form-control"><br>
				<textarea name="<%= AppConstant.TEXT_LABEL %>" class="form-control" rows="10">${news.text}</textarea><br>
                <input type="hidden" name="<%= AppConstant.ACTION_LABEL %>" value="<%= AppConstant.REFACTOR_ACTION_VALUE %>">
                <input type="hidden" name="<%= AppConstant.NEXT_PAGE_LABEL %>" value="<%= AppConstant.MY_NEWS_JSP %>">
                <input type="submit" value="Изменить новость" class="btn btn-success">
			</div>
	    </div>
    </form>
</div>

<c:import url="add/foot.jsp"/>
</body>
</html>