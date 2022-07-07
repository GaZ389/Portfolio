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
	<title>Add news</title>
</head>
<body>

<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Warning!!!</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <h2>Вы уверены что хотите удалить эту новость?</h2>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Нет</button>
        <button type="button" class="btn btn-danger">Да</button>
      </div>
    </div>
  </div>
</div>

<c:import url="add/menu.jsp"/>

<div class="container c_corr">
	<div class="row">
		<div class="col-md-12"><br>
			<h2>Добавить новость</h2>
			<c:if test="${message != null}">
				<p style="color: #ff0000">${message}</p>
			</c:if>
			<form method="post" action="<c:url value="<%= AppConstant.SAVE_NEWS_CONT %>"/>">
				<input type="text" name="<%= AppConstant.TITLE_LABEL %>" class="form-control" placeholder="Введите заголовок новости"><br>
				<textarea name="<%= AppConstant.TEXT_LABEL %>" class="form-control" placeholder="Введите текст новости" rows="5"></textarea>
				<input type="file" name="<%= AppConstant.IMAGE_LABEL %>" class="form-control"><br>
				<input type="hidden" name="<%= AppConstant.ACTION_LABEL %>" value="<%= AppConstant.ADD_ACTION_VALUE %>">
				<input type="submit" value="Добавить новость" class="btn btn-success">
			</form>
		</div>
	</div>
</div>

<c:import url="add/foot.jsp"/>
</body>
</html>