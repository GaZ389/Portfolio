package by.itclass.filters;

import by.itclass.constants.AppConstant;
import by.itclass.model.entities.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter",
           urlPatterns = {AppConstant.CABINET_JSP,
                          AppConstant.ADD_NEWS_JSP,
                          AppConstant.EDIT_NEWS_JSP } )
public class SecurityFilter implements Filter {
    public void destroy() {
        System.out.println("Filter destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();

        Object user = session.getAttribute(AppConstant.USER_ATTR);
        if (user != null) {
            chain.doFilter(req, resp);
        } else {
            request.getRequestDispatcher(AppConstant.NEWS_LIST_CONT)
                   .forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter init");
    }

}
