package modele;
import java.util.ArrayList;

public class Partie extends Joueur {
    private long Identifiant;
    private ArrayList<Joueur> joueur = new ArrayList<Joueur>();

    public Partie(){
        Identifiant= Long.parseLong(null);
        joueur =null;
    }

    public Partie(long Identifiant, ArrayList<Joueur> joueur){
        super();
        this.Identifiant=Identifiant;
        this.joueur = joueur;
    }



    public void ajouterJoueur(Joueur j){
        joueur.add(j);
    }

    public long getIdentifiant(){
        return Identifiant;
    }

    public ArrayList<Joueur> getjoueur(){
        return joueur;
    }

    public void setIdentifiant(long Identifiant){
        this.Identifiant=Identifiant;
    }
}
