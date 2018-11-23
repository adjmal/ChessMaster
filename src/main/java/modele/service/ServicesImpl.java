package modele.service;

import modele.Exceptions.*;
import modele.Joueur;
import modele.Partie;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ServicesImpl implements AdministrationService, modele.services.GestionPartieService {

    private Map<String, Joueur> JoueursInscrit;
    private Collection<String> joueursConnectes;
    private Collection<String> joueurDnsPartie;

    public ServicesImpl() {
        JoueursInscrit = new HashMap<String, Joueur>();
        joueursConnectes = new HashSet<String>();
        joueurDnsPartie = new HashSet<String>();

    }

    public void inscription(String pseudo, String motDePasse, String confirmationMDP)
            throws PseudoDejaPrisException, ConfirmationMDPException, DonneesException {
        if (pseudo == null || motDePasse == null || confirmationMDP == null) {
            throw new DonneesException();
        }
        if (!motDePasse.equals(confirmationMDP)) {
            throw new ConfirmationMDPException();
        }

        if (JoueursInscrit.containsKey(pseudo)) {
            throw new PseudoDejaPrisException();
        }

        Joueur nouveauJoueur = Joueur.creerJoueur(pseudo, motDePasse);
        JoueursInscrit.put(pseudo, nouveauJoueur);

    }

    public void connexion(String pseudo, String mdp) throws DonneesException, DejaConnecteException {
        Joueur j = JoueursInscrit.get(pseudo);
        if (j == null) {
            throw new DonneesException();
        }

        if (!j.isMdP04(mdp)) {
            throw new DonneesException();
        }

        if (joueursConnectes.contains(pseudo)) {
            throw new DejaConnecteException();
        }

        joueursConnectes.add(pseudo);

    }

    public void deconnexion(String pseudo) {
        joueursConnectes.remove(pseudo);

    }

    public void desabonnement(String pseudo, String mdp) throws DonneesException {
        Joueur j = JoueursInscrit.get(pseudo);
        if (j == null) {
            throw new DonneesException();
        }

        if (!j.isMdP04(mdp)) {
            throw new DonneesException();
        }

        JoueursInscrit.remove(j);

    }

    public long creerUnePartie(String pseudo) throws DejaImpliqueDansUnePartie, PseudoNonConnecteException {
        Joueur j = JoueursInscrit.get(pseudo);
        Partie partie = new Partie();
        if (!joueursConnectes.contains(j)) {
            throw new PseudoNonConnecteException();
        }
        if (joueurDnsPartie.contains(j)) {
            throw new DejaImpliqueDansUnePartie();
        }

        return partie.getIdentifiant();


    }

    public void rejoindreUnePartie(String pseudo, long idPartieConcernee) throws PseudoNonConnecteException {
        Joueur j = JoueursInscrit.get(pseudo);
        Partie partie = new Partie();
        if (!joueursConnectes.contains(j)) {
            throw new PseudoNonConnecteException();
        }

        joueurDnsPartie.add(pseudo);
        partie.setIdentifiant(idPartieConcernee);

    }

    public void quitterUnePartie(String pseudo, long idPartieConcernee) throws PseudoNonConnecteException {
        Joueur j = JoueursInscrit.get(pseudo);
        Partie partie = new Partie();
        if (!joueursConnectes.contains(j)) {
            throw new PseudoNonConnecteException();
        }

        joueurDnsPartie.remove(j);
        partie.setIdentifiant(idPartieConcernee);
    }

    public Collection<Partie> getPartiesEnAttenteDeJoueurs(String pseudo) throws PseudoNonConnecteException {
        Joueur j = JoueursInscrit.get(pseudo);
        Collection<Partie> ListePartieEnAttente;
        if (!joueursConnectes.contains(j)) {
            throw new PseudoNonConnecteException();
        }

        ListePartieEnAttente = new HashSet<Partie>();
        return ListePartieEnAttente;

    }

    public Collection<Partie> getPartiesEnCours(String pseudo) throws PseudoNonConnecteException {
        return null;
    }


    public Partie getPartieById(String pseudo, long idPartie) throws PseudoNonConnecteException {
        Joueur j = JoueursInscrit.get(pseudo);
        Partie partie = new Partie();
        if (!joueursConnectes.contains(j)) {
            throw new PseudoNonConnecteException();
        }
        if (partie.getIdentifiant() == idPartie) {
            return partie;
        }else{
            return null;
        }

    }
}
