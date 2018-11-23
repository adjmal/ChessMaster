package modele.piece;

import modele.Case;
import modele.CouleurPiece;
import modele.Piece;
import modele.QuestionnerPlateau;

public class Cavaliers implements Piece {

    private CouleurPiece couleurPiece;
    private QuestionnerPlateau plateau;

    public Cavaliers(CouleurPiece couleurPiece,QuestionnerPlateau plateau){
        this.couleurPiece = couleurPiece;
        this.plateau = plateau;
    }

    public boolean deplacementValide(Case aCase, char xf, int yf) {

        Case caseDestination = Case.getCase(xf, yf);

        int deltaX = (int) xf - (int) aCase.getColumn();
        int deltaY = yf - aCase.getRow();
        int carre = deltaX*deltaX + deltaY*deltaY;

        if (carre == 5)
            return !plateau.caseOccupeeParPieceAdverse(couleurPiece, caseDestination);
        else
            return false;
    }

    public CouleurPiece getCouleur() {
        return couleurPiece;
    }

}
