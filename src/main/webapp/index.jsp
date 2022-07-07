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
	<title>MySite</title>
</head>
<body>
<c:import url="add/menu.jsp"/>

<br><br>
<div class="container">
	<div class="row">
		<div class="col-md-8">
			<c:if test="${not empty newsList}">
				<a href="/news.jsp" class="news_link">
					<div class="main_news_block">
						<img src="image/kybok.jpg" class="img-fluid">
						<div class="for_text_news">
							<center>
								<h2>${newsList[0].title}</h2>
							</center>
							<p>${newsList[0].text}</p>
							<span class="time">${newsList[0].time} | ${newsList[0].date}</span>
						</div>
					</div>
				</a>
			</c:if>
		</div>
		<div class="col-md-4">
			<c:forEach var="news" items="${newsList}" begin="1" end="2">
				<a href="/news.jsp" class="news_link">
					<div class="main_news_block">
						<img src="image/kybok.jpg" class="img-fluid cor_m">
						<div class="for_text_news">
							<h2>${news.title}</h2>
							<span class="time">${news.time} | ${news.date}</span>
						</div>
					</div>
				</a>
			</c:forEach>
		</div>
	</div>
	<c:forEach var="news" items="${newsList}" begin="3">
		<div class="row">
			<div class="col-md-12 news">
				<div class="row">
					<div class="col-md-4">
						<img src="image/fytbolist.jpg" class="img-fluid">
					</div>
					<div class="col-md-8">
						<h4>${news.title}</h4>
						<p>${news.text}</p>
						<span class="time">${news.time} | ${news.date}</span>
						<a href="/news.jsp">Читать в источнике</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<div class="row">
		<div class="col-md-12">
			<nav aria-label="Page navigation example">
              <ul class="pagination justify-content-center">
                <li class="page-item disabled">
                  <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                  <a class="page-link" href="#">Next</a>
                </li>
              </ul>
            </nav>
		</div>
	</div>
</div>
<c:import url="add/foot.jsp"/>
</body>
</html>