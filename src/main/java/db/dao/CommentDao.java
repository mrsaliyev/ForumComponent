package db.dao;

import bean.Comment;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    public static boolean save(Comment comment){
        boolean status = false;
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("insert into comment values(?,?,?,?)");
            ps.setInt(1,comment.getPostId());
            ps.setInt(2,comment.getUserId());
            ps.setString(3,comment.getText());
            ps.setInt(4,comment.getCntLike());
            ps.executeUpdate();
            status = true;
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }

    public List<Comment> getCommentsByPostID(Integer postId) {
        List<Comment> comments = new ArrayList<>();
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("select * from comment where postId=?");
            ps.setInt(1,postId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Integer userId = rs.getInt("user_id");
                Integer postId_ = rs.getInt("post_id");
                String text = rs.getString("text");
                Integer countLike = rs.getInt("likes");

                comments.add(new Comment(id, userId, postId_, text, countLike));
            }
            con.close();

        }catch(Exception e){System.out.println(e);}

        return comments;
    }

    public int getCntLikeId(Integer postId) {
        int cnt= 0;
        try {
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("select * from comment where postId=?");
            ps.setInt(1,postId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cnt++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cnt;
    }
}
