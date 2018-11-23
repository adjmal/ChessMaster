package modele.Remote;

import modele.Exceptions.ConfirmationMDPException;
import modele.Exceptions.DejaConnecteException;
import modele.Exceptions.DonneesException;
import modele.Exceptions.PseudoDejaPrisException;
import modele.service.ServicesImpl;

import java.rmi.RemoteException;

public class ServiceImplRemote implements AdministrationServiceRemote{

    public void inscription(String pseudo, String motDePasse, String confirmationMotDePasse) throws RemoteException, PseudoDejaPrisException, ConfirmationMDPException, DonneesException {

    }

    public void connexion(String pseudo, String mdp) throws RemoteException, DonneesException, DejaConnecteException {

    }

    public void deconnexion(String pseudo) {

    }

    public void desabonnement(String pseudo, String mdp) throws RemoteException, DonneesException {

    }
}
