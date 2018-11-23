package modele.service;

import modele.Exceptions.ConfirmationMDPException;
import modele.Exceptions.DejaConnecteException;
import modele.Exceptions.DonneesException;
import modele.Exceptions.PseudoDejaPrisException;
import org.junit.Test;

public class TestServicesImp {

    @Test(expected = ConfirmationMDPException.class)
    public void testInscriptionK01() throws PseudoDejaPrisException, ConfirmationMDPException,DonneesException{
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("adjmal","123","12k");
    }

    @Test(expected = PseudoDejaPrisException.class)
    public void testInscriptionK02() throws PseudoDejaPrisException, DonneesException, ConfirmationMDPException{
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("adjmal","123","123");
        administrationService.inscription("adjmal","456","456");
    }
    @Test(expected = DonneesException.class)
    public void testInscriptionK03() throws PseudoDejaPrisException, DonneesException, ConfirmationMDPException{
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription(null,"123","123");

    }

    @Test(expected = DonneesException.class)
    public void testInscriptionK04() throws PseudoDejaPrisException, DonneesException, ConfirmationMDPException{
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("adjmal",null,"123");

    }

    @Test(expected = DonneesException.class)
    public void testInscriptionK05() throws PseudoDejaPrisException, DonneesException, ConfirmationMDPException{
        AdministrationService administrationService = new ServicesImpl();
        administrationService.inscription("adjmal","123",null);

    }

    @Test(expected =DonneesException.class)
    public void testConnexionk01() throws PseudoDejaPrisException, DonneesException, ConfirmationMDPException, DejaConnecteException {
        AdministrationService administrationService =new ServicesImpl();
        administrationService.inscription("y","y","y");
        administrationService.connexion(null,"y");
    }

    @Test(expected =DonneesException.class)
    public void testConnexionk02() throws DonneesException,DejaConnecteException {
        AdministrationService administrationService =new ServicesImpl();
        administrationService.connexion("y","y");
    }

    @Test
    public void testDeconnexion(){
        AdministrationService administrationService=new ServicesImpl();
        administrationService.deconnexion("x");

    }

    @Test
    public void testDesabonnement() throws DonneesException{
        AdministrationService administrationService=new ServicesImpl();
        administrationService.desabonnement("x","y");

    }


}
