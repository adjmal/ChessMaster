package modele;
import modele.piece.Tours;
import org.junit.Assert;
import org.junit.Test;

public class TestTours {
    @Test
    public void TestDeplacementImpossible(){
        QuestionnerPlateau plateau= new QuestionnerPlateau(){
            public boolean caseOccupeeParPieceAdverse(CouleurPiece couleurpiece,Case caseP){
                Case a5=Case.getCase('g',5);
                if((caseP==a5) && couleurpiece == CouleurPiece.NOIR){
                    return true;
                }
                return false;
            }

            public boolean pieceNonMenacee(CouleurPiece couleurpiece,Case aCase){
                return false;
            }
        };
        Tours pions =new Tours(CouleurPiece.BLANC,plateau);
        Assert.assertFalse(pions.deplacementValide(Case.getCase('e',3),'e',8));//attendre que ca retourne faux
    }

}
