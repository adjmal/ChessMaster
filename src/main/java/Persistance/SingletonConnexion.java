package Persistance;

import java.sql.*;

public class SingletonConnexion {
    private static Connection c =null;
    public static  Connection getConnection() throws SQLException{
        if(c==null){

        String Login = "...";
        String password = "...";
        String bd = "bd...";
        String machine = "dbhost";
        String port ="3306";
        c = DriverManager.getConnection("jdbc:mysql://" + machine + " " + port);
    }
    return c;
}
}
