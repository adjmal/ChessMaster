package modele;

public class test {
    public static void main(String[] args) {
        //test class case
        Case c = new Case('a',4);
        System.out.println(c.getColumn());
        System.out.println(c.getRow());
        System.out.println("map");
        System.out.println(c.getCase('a',4));
        //test enum
        for(CouleurPiece CoulP : CouleurPiece.values()){
                System.out.println(CoulP);
        }

        //Piece d'echequier

    }
    }
