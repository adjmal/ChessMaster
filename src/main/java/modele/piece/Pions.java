package modele.piece;

import modele.Case;
import modele.CouleurPiece;
import modele.Piece;
import modele.QuestionnerPlateau;

public class Pions  implements Piece {

    private CouleurPiece couleurPiece;
    private QuestionnerPlateau plateau;

    public Pions(CouleurPiece couleurpiece,QuestionnerPlateau plateau){
        this.couleurPiece=couleurpiece;
        this.plateau=plateau;
    }

    public boolean deplacementValide(Case aCase, char xf, int yf) {
        //cas1
        Case caseDestination = Case.getCase(xf, yf);
        int res = yf-aCase.getRow();
        int res2= yf-aCase.getRow();
        int resC= (int) aCase.getColumn() - (int) xf;
        System.out.println("res1 "+(int)aCase.getColumn());
        System.out.println("res2 "+xf);
        System.out.print(resC);
        if(aCase.getColumn()==xf && res==1){
            return !plateau.caseOccupeeParPieceAdverse(couleurPiece, caseDestination);
        }
        if(aCase.getRow()==2 && aCase.getColumn()==xf && res2==2){
            return !plateau.caseOccupeeParPieceAdverse(couleurPiece,caseDestination);
        }
        if(resC==1 || resC==-1 && yf==aCase.getRow()+1){
            System.out.print("caseOccupe");
            return plateau.caseOccupeeParPieceAdverse(couleurPiece,caseDestination);
        }
        else{
            return false;
        }

    }


    public CouleurPiece getCouleur(){return couleurPiece; }


}
