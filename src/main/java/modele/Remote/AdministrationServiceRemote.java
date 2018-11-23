package modele.Remote;

import modele.Exceptions.ConfirmationMDPException;
import modele.Exceptions.DejaConnecteException;
import modele.Exceptions.DonneesException;
import modele.Exceptions.PseudoDejaPrisException;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdministrationServiceRemote extends Remote {
    void inscription(String pseudo, String motDePasse, String confirmationMotDePasse)
            throws RemoteException,PseudoDejaPrisException, ConfirmationMDPException, DonneesException;


    void connexion(String pseudo, String mdp) throws RemoteException, DonneesException, DejaConnecteException;

    void deconnexion(String pseudo);


    void desabonnement(String pseudo, String mdp) throws RemoteException,DonneesException;

}
