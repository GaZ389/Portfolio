package by.itclass.controllers.abstracts;

import by.itclass.constants.AppConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AbstractController")
public abstract class AbstractController extends HttpServlet {

    protected void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        request.getRequestDispatcher(url)
               .forward(request, response);
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response, String url, String message) throws ServletException, IOException {
        request.setAttribute(AppConstant.MESSAGE_ATTR, message);
        forward(request, response, url);
    }

    protected void redirect(HttpServletResponse response, String url) throws ServletException, IOException {
        response.sendRedirect(getServletContext().getContextPath() + url);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
