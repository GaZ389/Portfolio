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

@WebServlet(name = "EditController", urlPatterns = AppConstant.EDIT_CONT)
public class EditController extends AbstractController {
    private UserService service;

    public EditController() {
        service = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(AppConstant.LOGIN_LABEL);
        String email = request.getParameter(AppConstant.EMAIL_LABEL);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(AppConstant.USER_ATTR);

        service.edit(user, login, email);
        redirect(response, AppConstant.CABINET_JSP);
    }
}
