package servlet;

import bean.User;
import db.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        if(userDao.check(login, password) == true ){
            HttpSession session = request.getSession();
            session.setAttribute("login","true");
            session.setMaxInactiveInterval(30*60);
            Cookie loginCookie = new Cookie("login", login);
            loginCookie.setMaxAge(30*60);
            response.addCookie(loginCookie);
            request.getRequestDispatcher("createPost.jsp").include(request, response);
        }else{
            request.getRequestDispatcher("login.jsp").include(request, response);
        }

    }
}
