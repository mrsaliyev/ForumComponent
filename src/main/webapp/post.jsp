<%@ page import="bean.Comment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="postDao" class="db.dao.PostDao" scope="session"/>
<jsp:useBean id="commentDao" class="db.dao.CommentDao" scope="session"/>
<jsp:useBean id="userDao" class="db.dao.UserDao" scope="session"/>
<jsp:useBean id="post" class="bean.Post" scope="session"/>
<%
    int postId = Integer.parseInt(request.getParameter("id"));
    post = postDao.getPostsByID(postId);
    List<Comment> comments = new ArrayList<>(commentDao.getCommentsByPostID(postId));

    String commentsStr = "";
    for (Comment c : comments) {
        commentsStr += "<div>\n" +
                "                <div>\n" +
                "                    <p>\n" +
                "                        " + c.getText() + "\n" +
                "                    </p>\n" +
                "                </div>\n" +
                "                <div>\n" +
                "                    <div>\n" +
                "                        <div>\n" +
                "                            " + commentDao.getCntLikeId(c.getPostId()) + " likes\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                    <div>\n" +
                "                        <div>\n" +
                "                            " + userDao.getById(c.getId()).getLogin() + "\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Post Page</title>
</head>
<body>

<%@ include file="header.jsp"%>

<div>
    <div>
        <h1><%= post.getTitle() %></h1>
    </div>
    <div>
        <p><%= post.getText() %></p>
    </div>
    <div>Comments</div>
    <div>
        <%= commentsStr %>
    </div>

</div>

</body>
</html>
