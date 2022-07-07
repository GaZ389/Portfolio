package by.itclass.controllers.news;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracts.AbstractController;
import by.itclass.model.entities.News;
import by.itclass.model.db.enums.NewsListMode;
import by.itclass.model.services.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewsListController", urlPatterns = AppConstant.NEWS_LIST_CONT)
public class NewsListController extends AbstractController {
    private NewsService service;

    public NewsListController() {
        service = new NewsService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = request.getParameter(AppConstant.NEXT_PAGE_LABEL);;
        String param = request.getParameter(AppConstant.PARAM_LABEL);
        NewsListMode newsListMode = null;

        System.out.println("param:" + param);

        if (nextPage == null) {
            nextPage = AppConstant.INDEX_JSP;
            newsListMode = NewsListMode.ALL_NEWS;
        } else if (nextPage.equals(AppConstant.MY_NEWS_JSP)) {
            newsListMode = NewsListMode.MY_NEWS;//<-- Для получения SQL запроса в DAO
        } else {
            newsListMode = NewsListMode.ALL_NEWS;
        }

        List<News> newsList = service.listByMode(newsListMode, param);
        request.setAttribute(AppConstant.NEWS_LIST_ATTR, newsList);
        forward(request, response, nextPage);
    }
}
