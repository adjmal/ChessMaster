package Persistance;

import java.sql.*;

public class EssaieConnexion {
    public static void main(String[] args) {
        try{
            Connection c= DriverManager.getConnection("jdbc:mysql://dbhost:3306/bd_36006038");
            Statement st= c.createStatement();
            ResultSet rs=st.executeQuery("Show Table ");
            System.out.print(rs.getRow());
            while (rs.next()){
                System.out.print(rs.getString(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
