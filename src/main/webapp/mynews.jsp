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
    <title>My news</title>
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
        <div class="col-md-12">
            <table class="table table-bordered">
                <tr>
                    <th>id</th>
                    <th>img</th>
                    <th>title</th>
                    <th>text</th>
                    <th>action</th>
                </tr>
                <c:forEach var="news" items="${newsList}">
                    <tr>
                        <td>${news.id}</td>
                        <td>
                            <img src="${news.image}" height="100px">
                        </td>
                        <td>
                            <p>${news.title}</p>>
                        </td>
                        <td>
                            <p>${news.text}</p>
                        </td>
                        <td>
                            <a href="<c:url value="<%= AppConstant.VIEW_NEWS_CONT %>">
                                        <c:param name="<%= AppConstant.ID_LABEL %>" value="${news.id}"/>
                                     </c:url>"
                               class="btn btn-warning">Edit</a>
                            <a href="JavaScript:sendDeleteNewsForm('${news.id}')" class="btn btn-danger">Delete</a>
                            <!--<button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#staticBackdrop">delete</button>-->
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <form id="deleteNewsForm" method="post" action="<c:url value="<%= AppConstant.DELETE_NEWS_CONT %>"/>">
                <input type="hidden" name="<%= AppConstant.ID_LABEL %>">
            </form>
        </div>
    </div>
</div>

<c:import url="add/foot.jsp"/>
</body>
</html>