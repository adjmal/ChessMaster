/*package Persistance;

import modele.Joueur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JoueurBD {

    public void existe(String pseudo){
        try{
            Connection c=SingletonConnexion.getConnection();
            PreparedStatement ps = c.prepareStatement(
                    "select pseudo,MDP";
                    "from Joueur where pseudo=?");
            ps.setString(1,pseudo);
            ResultSet rs =ps.executeQuery();
            if(rs.next()==true){
                String pseudolu = ((ResultSet) rs).getString(1);
                String mdplu = rs.getString(2);
                Joueur j =Joueur.creerJoueur(pseudolu,mdplu);
                return j;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Joueur> finall(){
        List<Joueur> lst=new ArrayList<Joueur>();
        try{
            Statement st=SingletonConnexion.getConnection().createStatement();
            ResultSet rs=st.executeQuery("SELECT pseudo,mdp FROM JOUEUR");
            while (rs.next()==true){
                String pseudolu=rs.getString(1);
                String mdplu=rs.getString(2);
                Joueur j=Joueur.creerJoueur(pseudolu,mdplu);
                lst.add(j);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return lst;
    }

    public boolean create(Joueur j){
        try {
            Connection c=SingletonConnexion.getConnection();
            PreparedStatement ps =c.prepareStatement("insert into Joueur(pseudo,mdp) values (?,?)");
            ps.setString(1,j.getPseudo());
            int res=ps.executeUpdate();
            return (res==1);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
*/