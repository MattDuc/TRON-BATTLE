import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        /// map représentant la grille du jeu
        int map[][] = new int[32][22]; /// map de dimension (32;22) pour représenter les murs
        for(int k = 0; k<32; k++){
            for(int l = 0; l<22; l++){
                map[k][l]=0;  ///On initialise la map avec des 0
            }
        }
        /// On met des 1 pour représenter les murs
        for(int j = 0; j<22; j++){
            map[0][j]=1;
            map[31][j]=1;
        }
        for(int m = 0; m<32; m++){
            map[m][0]=1;
            map[m][21]=1;
        }
        boolean continuer = false;
        // Boucle représentant un tour
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).
            int positionX[] = new int[N];  /// Tableau pour stocker les abcisses des coordonées de chaque joueur à chaque tour
            int positionY[] = new int[N]; /// Tableau pour stocker les ordonées des coordonées de chaque joueur à chaque tour
            int positionX0[] = new int[N];  /// Tableau pour stocker l'abcisse de départ de chaque joueur
            int positionY0[] = new int[N];  /// Tableau pour stocker l'ordonnée de départ de chaque joueur
            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                map[X0+1][Y0+1]=2;  /// Les 2 représentent les lumicycles
                positionX0[i]=X0;   /// On stocke les coordonées de départ
                positionY0[i]=Y0;
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
                map[X1+1][Y1+1]=2; /// Les 2 représentent les lumicycles
                positionX[i]=X1;  ///On stocke les coordonées de chaque joueur à chaque tour
                positionY[i]=Y1;
            }

            /// La case suivante est-elle libre?
            boolean direction[] = new boolean[8]; /// Tableau de booléen représentant chaque direction (false si la case est occupé)
            for (int n = 0; n<8; n++){
                direction[n] = true;
            }
            ///(0:Nord),(1:Nord Ouest),(2:Ouest),(3:Sud Ouest),(4:Sud),(5:Sud Est),(6:Est),(7:Nord Est)
            /// Attention au décalage de la map
            if(contenir(map[positionX[P]+1][positionY[P]])){
                direction[0] = false;
            }

            if(contenir(map[positionX[P]][positionY[P]])){
                direction[1] = false;
            }

            if(contenir(map[positionX[P]][positionY[P]+1])){
                direction[2] = false;
            }

            if(contenir(map[positionX[P]][positionY[P]+2])){
                direction[3] = false;
            }

            if(contenir(map[positionX[P]+1][positionY[P]+2])){
                direction[4] = false;
            }

            if(contenir(map[positionX[P]+2][positionY[P]+2])){
                direction[5] = false;
            }

            if(contenir(map[positionX[P]+2][positionY[P]+1])){
                direction[6] = false;
            }

            if(contenir(map[positionX[P]+2][positionY[P]])){
                direction[7] = false;
            }

            /// Détermination du chemin
            /// Si on joue alors jouer = false et on ne peut plus jouer sur ce tour
            boolean jouer = true; ///Bouléen pour savoir si on peut encore jouer sur ce tour
            if((positionX0[P]<=15)&&(positionY0[P]<=10)){ /// Si on est en haut à gauche du jeu
                if(continuer){
                    if(direction[2]&&jouer){
                        System.out.println("LEFT");
                        jouer = false;
                    }
                    else continuer = false;
                }
                if(direction[4]&&jouer){
                    System.out.println("DOWN");
                    jouer = false;
                }
                if(direction[6]&&jouer){
                    System.out.println("RIGHT");
                    jouer = false;
                }
                if(direction[0]&&jouer){
                    System.out.println("UP");
                    jouer = false;
                }
                if(direction[2]&&jouer){
                        System.out.println("LEFT");
                        jouer = false;
                        continuer = true;
                }
            }
            if((positionX0[P]<=15)&&(positionY0[P]>=10)){ /// Si on est en bas à gauche du jeu
                if(continuer){
                    if(direction[2]&&jouer){
                        System.out.println("LEFT");
                        jouer = false;
                    }
                    else continuer = false;
                }
                if(direction[0]&&jouer){
                    System.out.println("UP");
                    jouer = false;
                }
                if(direction[6]&&jouer){
                    System.out.println("RIGHT");
                    jouer = false;
                }
                if(direction[4]&&jouer){
                    System.out.println("DOWN");
                    jouer = false;
                }
                if(direction[2]&&jouer){
                    System.out.println("LEFT");
                    jouer = false;
                    continuer = true;
                }
            }
            if((positionX0[P]>=15)&&(positionY0[P]<=10)){ /// Si on est en haut à droite du jeu
                if(continuer){
                    if(direction[6]&&jouer){
                        System.out.println("RIGHT");
                        jouer = false;
                    }
                    else continuer = false;
                }
                if(direction[4]&&jouer){
                    System.out.println("DOWN");
                    jouer = false;
                }
                if(direction[2]&&jouer){
                    System.out.println("LEFT");
                    jouer = false;
                }
                if(direction[0]&&jouer){
                    System.out.println("UP");
                    jouer = false;
                }
                if(direction[6]&&jouer){
                    System.out.println("RIGHT");
                    jouer = false;
                    continuer = true;
                }
            }
            if((positionX0[P]>=15)&&(positionY0[P]>=10)){ /// Si on est en bas à droite du jeu
                if(continuer){
                    if(direction[6]&&jouer){
                    System.out.println("RIGHT");
                    jouer = false;
                    }
                    else continuer = false;
                }
                if(direction[0]&&jouer){
                    System.out.println("UP");
                    jouer = false;
                }
                if(direction[2]&&jouer){
                    System.out.println("LEFT");
                    jouer = false;
                }
                if(direction[4]&&jouer){
                    System.out.println("DOWN");
                    jouer = false;
                }
                if(direction[6]&&jouer){
                    System.out.println("RIGHT");
                    jouer = false;
                    continuer = true;
                }
            }
        }
    }
    /// fonction range pour tester les cases occupées par des 1 ou des 2
    public static boolean contenir(int i) {
        return (i >= 1  && i <= 2);

    }
}
