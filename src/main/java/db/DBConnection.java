package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection con;

    public static Connection getCon(){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forum",
                    "postgres","123456");

        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
