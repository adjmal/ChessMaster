package modele.piece;

import modele.Case;
import modele.CouleurPiece;
import modele.Piece;
import modele.QuestionnerPlateau;

public class Tours implements Piece {

    private CouleurPiece couleurPiece;
    private QuestionnerPlateau plateau;

    public Tours(CouleurPiece couleurPiece, QuestionnerPlateau plateau) {
        this.couleurPiece = couleurPiece;
        this.plateau = plateau;
    }

    public boolean deplacementValide(Case aCase, char xf, int yf) {
        int i;
        int j;
        int row[] = {1, 2, 3, 4, 5, 6, 7, 8};
        char column[] = {'a', 'b', 'c', 'd', 'e', 'g', 'h', 'i'};
        Case caseDestination = Case.getCase(xf, yf);

        for (i = 0; i < row.length; i++) {
            if (aCase.getColumn() == xf && yf == i) {
                return !plateau.caseOccupeeParPieceAdverse(couleurPiece, caseDestination);
            }
        }
        for (j = 0; j < row.length; j++) {
            if (aCase.getRow() == yf && xf == j) {
                return !plateau.caseOccupeeParPieceAdverse(couleurPiece, caseDestination);
            }
        }

        return true;

    }


    public CouleurPiece getCouleur() {
        return couleurPiece;
    }

}