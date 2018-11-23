package modele;
import modele.piece.Cavaliers;
import modele.piece.Pions;
import org.junit.Assert;
import org.junit.Test;

public class TestCavalier {
    @Test
    public void TestDeplacementImpossible(){
        QuestionnerPlateau plateau= new QuestionnerPlateau(){
            public boolean caseOccupeeParPieceAdverse(CouleurPiece couleurpiece,Case caseP){
                Case a5=Case.getCase('a',5);
                if((caseP==a5) && couleurpiece == CouleurPiece.NOIR){
                    return true;
                }
                return false;
            }

            public boolean pieceNonMenacee(CouleurPiece couleurpiece,Case aCase){
                return false;
            }
        };
        Cavaliers cavaliers =new Cavaliers(CouleurPiece.NOIR,plateau);
        Assert.assertFalse(cavaliers.deplacementValide(Case.getCase('d',4),'e',6));//attendre que ca retourne faux
    }

}
