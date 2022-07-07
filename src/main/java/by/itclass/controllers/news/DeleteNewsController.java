package by.itclass.controllers.news;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracts.AbstractController;
import by.itclass.model.entities.User;
import by.itclass.model.services.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteNewsController", urlPatterns = AppConstant.DELETE_NEWS_CONT)
public class DeleteNewsController extends AbstractController {
    private NewsService service;

    public DeleteNewsController() {
        service = new NewsService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter(AppConstant.ID_LABEL);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(AppConstant.USER_ATTR);

        if (service.delete(user.getId(), id)) {
            redirect(response, AppConstant.NEWS_LIST_CONT);
        } else {
            forward(request, response, AppConstant.NEWS_NOT_DELETED_MESSAGE);
        }
    }
}
