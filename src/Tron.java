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
        int map[][] = new int[32][22];
        for(int k = 0; k<32; k++){
            for(int l = 0; l<22; l++){
                map[k][l]=0;
            }
        }
        for(int j = 0; j<22; j++){
            map[0][j]=1;
            map[31][j]=1;
        }
        for(int m = 0; m<32; m++){
            map[m][0]=1;
            map[m][21]=1;
        }
        // game loop
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).
            int positionX[] = new int[N];
            int positionY[] = new int[N];
            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                map[X0+1][Y0+1]=1;
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
                map[X1+1][Y1+1]=1;
                positionX[i]=X1;
                positionY[i]=Y1;
            }

            boolean direction[] = new boolean[4];
            for (int n = 0; n<4; n++){
                direction[n] = true;
            }
            //(0:haut),(1:gauche),(2:bas),(3:droite)
            if(map[positionX[P]+1][positionY[P]]==1){
                direction[0] = false;
            }

            if(map[positionX[P]][positionY[P]+1]==1){
                direction[1] = false;
            }

            if(map[positionX[P]+1][positionY[P]+2]==1){
                direction[2] = false;
            }

            if(map[positionX[P]+2][positionY[P]+1]==1){
                direction[3] = false;
            }

            boolean jouer = true;
            if(direction[0]&&jouer){
                System.out.println("UP");
                jouer = false;
            }
            if(direction[1]&&jouer){
                System.out.println("LEFT");
                jouer = false;
            }
            if(direction[2]&&jouer){
                System.out.println("DOWN");
                jouer = false;
            }
            if(direction[3]&&jouer){
                System.out.println("RIGHT");
                jouer = false;
            }

        }
    }
}
