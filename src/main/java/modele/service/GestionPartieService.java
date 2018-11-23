package modele.services;

import modele.Partie;
import modele.Exceptions.DejaImpliqueDansUnePartie;
import modele.Exceptions.PseudoNonConnecteException;

import java.util.Collection;


public interface GestionPartieService {
    /**
     *
     * @param pseudo du joueur qui veut créer une partie
     * @return identifiant de la partie créee
     */
    long creerUnePartie(String pseudo) throws
            DejaImpliqueDansUnePartie, PseudoNonConnecteException;

    void rejoindreUnePartie(String pseudo, long idPartieConcernee) throws
            PseudoNonConnecteException;;

    void quitterUnePartie(String pseudo, long idPartieConcernee) throws
            PseudoNonConnecteException;

    Collection<Partie> getPartiesEnAttenteDeJoueurs(String pseudo) throws
            PseudoNonConnecteException;

    Collection<Partie> getPartiesEnCours(String pseudo) throws
            PseudoNonConnecteException;


    Partie getPartieById(String pseudo, long idPartie) throws
            PseudoNonConnecteException;



}
