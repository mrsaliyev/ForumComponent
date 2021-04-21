package db.dao;
import bean.Post;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
    public static boolean save(Post post){
        boolean status = false;
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("insert into post values(?,?,?,?)");
            ps.setInt(1,post.getUserId());
            ps.setString(2,post.getTitle());
            ps.setString(3,post.getText());
            ps.setInt(4,post.getCntLike());
            ps.executeUpdate();
            status = true;
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }

    public Post getPostsByID(Integer postId) {
        Post post = new Post();
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("select * from post where id=?");
            ps.setInt(1,postId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                post.setId(rs.getInt(1));
                post.setUserId(rs.getInt(2));
                post.setTitle(rs.getString(3));
                post.setText(rs.getString(4));
                post.setCntLike(rs.getInt(5));
            }
            con.close();

        }catch(Exception e){System.out.println(e);}

        return post;
    }


    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("select * from post");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Integer userId = rs.getInt("user_id");
                String title = rs.getString("title");
                String text = rs.getString("text");
                Integer countLike = rs.getInt("likes");

                posts.add(new Post(id, userId, title, text, countLike));
            }
            con.close();

        }catch(Exception e){System.out.println(e);}

        return posts;
    }


}
