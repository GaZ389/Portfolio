<%@ page import="by.itclass.constants.AppConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="JavaScript:sendMenuForm('<%= AppConstant.INDEX_JSP %>', '<%= AppConstant.ALL_CATEGORY_LABEL %>')">Главная</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="onas.jsp">О нас</a>
        </li>
        <li class="nav-item dropdown active">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Спортивная котегория
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item active" href="#">Футбол</a></li>
            <li><a class="dropdown-item active" href="#">Хоккей</a></li>
            <li><a class="dropdown-item active" href="#">Шахматы</a></li>
          </ul>
        </li>
      </ul>

      <ul class="navbar-nav me-2 mb-2 mb-lg-0">
        <c:choose>
          <c:when test="${user == null}">
            <a class="nav-link active" aria-current="page" href="out.jsp">Авторизация</a>
            <a class="nav-link active" aria-current="page" href="reg.jsp">Регистрация</a>
            <a class="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Guest</a>
          </c:when>
          <c:otherwise>
            <li class="nav-item dropdown active">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  ${user.login}
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item active" href="cabinet.jsp">Кабинет</a></li>
                <li><a class="dropdown-item active" href="addnews.jsp">Добавить новость</a></li>
                <li><a class="dropdown-item active" href="JavaScript:sendMenuForm('<%= AppConstant.MY_NEWS_JSP %>', '${user.id}')">Мои новости</a></li>
                <li><a class="dropdown-item active" href="<c:url value="<%= AppConstant.LOGOUT_CONT %>"/>">Выход</a></li>
              </ul>
            </li>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
    <form id="menuForm" method="post" action="<c:url value="<%= AppConstant.NEWS_LIST_CONT %>"/>">
      <input type="hidden" name="<%= AppConstant.NEXT_PAGE_LABEL %>">
      <input type="hidden" name="<%= AppConstant.PARAM_LABEL %>">
    </form>
  </div>
</nav>
