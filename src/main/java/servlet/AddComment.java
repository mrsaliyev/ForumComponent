package servlet;

import bean.Comment;
import bean.Post;
import db.dao.CommentDao;
import db.dao.PostDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String comment = request.getParameter("text");

        if(CommentDao.save(new Comment(comment)) == true ){
            request.getRequestDispatcher("comment.jsp").include(request, response);
        }else{
            request.getRequestDispatcher("comment.jsp").include(request, response);
        }
    }
}
