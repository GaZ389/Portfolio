package by.itclass.controllers.news;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracts.AbstractController;
import by.itclass.model.entities.News;
import by.itclass.model.services.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.AbstractCollection;

@WebServlet(name = "ViewNewsController", urlPatterns = AppConstant.VIEW_NEWS_CONT)
public class ViewNewsController extends AbstractController {
    private NewsService service;

    public ViewNewsController() {
        service = new NewsService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter(AppConstant.ID_LABEL);

        News news = service.get(id);
        request.setAttribute(AppConstant.NEWS_ATTR, news);
        forward(request, response, AppConstant.EDIT_NEWS_JSP);
    }

}
