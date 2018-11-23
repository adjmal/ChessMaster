package modele;

public interface QuestionnerPlateau {
    boolean caseOccupeeParPieceAdverse(CouleurPiece couleurPiece, Case caseP);
    boolean pieceNonMenacee(CouleurPiece couleur, Case aCase);
}
