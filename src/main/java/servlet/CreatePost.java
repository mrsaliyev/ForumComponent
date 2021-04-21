package servlet;

import bean.Post;
import bean.User;
import db.dao.PostDao;
import db.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CreatePost")
public class CreatePost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String title = request.getParameter("title");
        String text = request.getParameter("text");

        if(PostDao.save(new Post(title,text)) == true ){
            request.getRequestDispatcher("comment.jsp").include(request, response);
        }else{
            request.getRequestDispatcher("createPost.jsp").include(request, response);
        }
    }
}
