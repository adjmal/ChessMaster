package modele;
import modele.piece.Pions;
import org.junit.Assert;
import org.junit.Test;

public class TestPion {
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
        Pions pions =new Pions(CouleurPiece.BLANC,plateau);
        Assert.assertFalse(pions.deplacementValide(Case.getCase('f',4),'f',5));//attendre que ca retourne faux
    }

}
