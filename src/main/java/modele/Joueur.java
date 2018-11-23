package modele;

public class Joueur {
    private String pseudo;
    private String motDePasse;

    Joueur(String pseudo,String motDePasse){
        this.pseudo=pseudo;
        this.motDePasse=motDePasse;
    }

    public Joueur() {

    }

    public static Joueur creerJoueur(String pseudo,String motDePasse){
        return new Joueur(pseudo, motDePasse);
    }

    public String getPseudo(){
        return pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
    public boolean isMdP04(String mdp){ return mdp.equals(motDePasse);}
}
