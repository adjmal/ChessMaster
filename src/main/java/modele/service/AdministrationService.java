package modele.service;


import modele.Exceptions.ConfirmationMDPException;
import modele.Exceptions.DejaConnecteException;
import modele.Exceptions.DonneesException;
import modele.Exceptions.PseudoDejaPrisException;

public interface AdministrationService {

    /**
     * Méthode de connexion
     * @param pseudo
     * @param motDePasse
     * @param confirmationMotDePasse
     */
    void inscription(String pseudo, String motDePasse, String confirmationMotDePasse)
            throws PseudoDejaPrisException, ConfirmationMDPException, DonneesException;


    void connexion(String pseudo, String mdp) throws DonneesException, DejaConnecteException;

    void deconnexion(String pseudo);


    void desabonnement(String pseudo, String mdp) throws DonneesException;
}
