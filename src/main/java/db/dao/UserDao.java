package db.dao;

import bean.User;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public static boolean save(User bean){
        boolean status = false;
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("insert into user values(?,?)");
            ps.setString(1,bean.getLogin());
            ps.setString(2,bean.getPassword());
            ps.executeUpdate();
            status = true;
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }

    public static User getById(int id){
        User user = new User();
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("select * from user where id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
            }
            con.close();

        }catch(Exception e){System.out.println(e);}

        return user;
    }

    public boolean check(String login, String password){
        String password2 = null;
        try{
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("select password from user where login =" + login);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 password2 = rs.getString(1);
            }
            con.close();

        }catch(Exception e){System.out.println(e);}

        if (password.equals(password2)){
            return true;
        }else {
            return false;
        }
    }

}
