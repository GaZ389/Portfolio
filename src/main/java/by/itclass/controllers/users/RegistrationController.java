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

@WebServlet(name = "RegistrationController", urlPatterns = AppConstant.REGISTRATION_CONT)
public class RegistrationController extends AbstractController {
    private UserService service;

    public RegistrationController() {
        service = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(AppConstant.LOGIN_LABEL);
        String password = request.getParameter(AppConstant.PASSWORD_LABEL);
        String email = request.getParameter(AppConstant.EMAIL_LABEL);

        if (service.registration(login, password, email)) {
            forward(request, response, AppConstant.AUTHORIZATION_CONT);
        } else {
            forward(request, response, AppConstant.REG_JSP, AppConstant.USER_WITH_THIS_LOGIN_EXISTS_MESSAGE);
        }
    }
}
