package servlet;

import bean.User;
import db.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(UserDao.save(new User(login,password)) == true ){
            request.getRequestDispatcher("createPost.jsp").include(request, response);
        }else{
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }
}
