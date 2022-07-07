package by.itclass.controllers.users;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.abstracts.AbstractController;
import by.itclass.model.entities.User;
import by.itclass.model.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthorizationController", urlPatterns = AppConstant.AUTHORIZATION_CONT)
public class AuthorizationController extends AbstractController {
    private UserService service;

    public AuthorizationController() {
        service = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(AppConstant.LOGIN_LABEL);
        String password = request.getParameter(AppConstant.PASSWORD_LABEL);

        User user = service.authorization(login, password);

        //Сценатрий контроллера
        if (user != null) {
            //Основной сценарий
            HttpSession session = request.getSession();
            session.setAttribute(AppConstant.USER_ATTR, user);//Запоминает пользователя на 30 минут по умолчанию
            redirect(response, AppConstant.NEWS_LIST_CONT);//Переходим на главную страницу
        } else {
            //Альтернативный сценарий
            forward(request, response, AppConstant.OUT_JSP, AppConstant.WRONG_LOGIN_OR_PASSWORD_MESSAGE);
        }
    }
}
