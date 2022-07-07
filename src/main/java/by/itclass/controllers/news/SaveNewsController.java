package by.itclass.controllers.news;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracts.AbstractController;
import by.itclass.model.db.enums.EnumManager;
import by.itclass.model.db.enums.NewsAction;
import by.itclass.model.entities.News;
import by.itclass.model.entities.User;
import by.itclass.model.services.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SaveNewsController", urlPatterns = AppConstant.SAVE_NEWS_CONT)
public class SaveNewsController extends AbstractController {
    private NewsService service;

    public SaveNewsController() {
        service = new NewsService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter(AppConstant.ID_LABEL);
        String title = request.getParameter(AppConstant.TITLE_LABEL);
        String text = request.getParameter(AppConstant.TEXT_LABEL);
        String image = request.getParameter(AppConstant.IMAGE_LABEL);
        String action = request.getParameter(AppConstant.ACTION_LABEL);

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute(AppConstant.USER_ATTR);
        News news = new News(user.getId(), id, title, text, image);
        NewsAction newsAction = EnumManager.getKindNewsAction(action);

        if (service.save(news, newsAction)) {
            redirect(response, AppConstant.RESULT_JSP);
        } else {
            if (newsAction == NewsAction.ADD) {
                forward(request, response, AppConstant.ADD_NEWS_JSP, AppConstant.INCORRECT_NEWS_DATA_MESSAGE);
            } else {
                forward(request, response, AppConstant.EDIT_NEWS_JSP, AppConstant.INCORRECT_NEWS_DATA_MESSAGE);
            }
        }
    }
}
