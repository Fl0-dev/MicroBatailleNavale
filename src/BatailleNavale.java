import java.util.Scanner;

/**
 * Programme tout simple de bataille navale sur une grille de 4x4
 * 1 joueur doit trouver un bateau placé aléatoirement
 */
public class BatailleNavale {
    static final int TAILLE = 4;
    static final char PLOUF = '~';
    static final char SMOKE = '?';
    static char[][] plateau;

    static {
        plateau = new char[TAILLE][TAILLE];
    }
    //ouverture du scan
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int col;
        int row;
        int colB = (int) (Math.random() * (4 - 0));
        int rowB = (int) (Math.random() * (4 - 0));
        // initialisation du plateau
        //Arrays.fill(plateau, SMOKE);
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau.length; j++) {
                plateau[i][j] = SMOKE;
            }
        }


        do {
            // Afficher plateau
            for (int i = 0; i < TAILLE; i++) {
                for (int j = 0; j < TAILLE; j++) {
                    System.out.print(plateau[i][j]);
                }
                System.out.println();
            }
            // Jouer un coup
            System.out.println("Quelle ligne ?");
            row = scan.nextInt();
            //si souci numéro de ligne
            while (row != 1 & row != 2 & row != 3 & row != 4) {
                System.out.println("La ligne doit être comprise entre 1 et 4");
                row = scan.nextInt();

            }
            row--;
            System.out.println("Quelle colonne ?");
            col = scan.nextInt();
            //si souci numéro de colonne
            while (col != 1 & col != 2 & col != 3 & col != 4) {
                System.out.println("La colonne doit être comprise entre 1 et 4");
                col = scan.nextInt();

            }
            col--;
            // message si case déjà visé
            if (plateau[row][col] == PLOUF) {
                System.out.println("Vous avez déjà visé cette case");
            // message si raté
            } else {
                plateau[row][col] = PLOUF;
                System.out.println("Plouf ! A l'eau");
            }

        } while (plateau[row][col] != plateau[rowB][colB]);
        //message si touché
        System.out.println("Boom ! Touché coulé");
        System.out.println("Bravo, vous avez gagné !");
    }
}


