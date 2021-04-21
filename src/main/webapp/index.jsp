<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="bean.Post" %>
<jsp:useBean id="postDao" class="db.dao.PostDao" scope="session"/>
<jsp:useBean id="commentDao" class="db.dao.CommentDao" scope="session"/>
<jsp:useBean id="userDao" class="db.dao.UserDao" scope="session"/>

<%
    List<Post> posts = new ArrayList<>(postDao.getPosts());
    String postStr = "";

    for (Post post : posts) {
        postStr += "<div>\n" +
                "                <a href=\"post?id="+ post.getId() + "\">\n" +
                "                    <div>" + post.getTitle() + "</div>\n" +
                "                </a>\n" +
                "\n" +
                "                <div>\n" +
                "\n" +
                "                    <div>\n" +
                "                        <span>" + post.getCntLike() + " likes</span>\n" +
                "                        <span>" + commentDao.getCommentsByPostID(post.getId()) + " comments</span>\n" +
                "                    </div>\n" +
                "\n" +
                "                    <div>\n" +
                "                        <div>\n" +
                "                            <div> publisher: " + userDao.getById(post.getUserId()).getLogin() + "</div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "            </div>";
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<%@ include file="header.jsp"%>

<div class="flex-div flex-direct-column">
    <div class="flex-child">
        <%= postStr %>
    </div>
</div>


</body>
</html>
