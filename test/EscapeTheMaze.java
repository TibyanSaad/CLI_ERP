package test;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;


public class EscapeTheMaze {
    public static void main(String[] args) throws IOException {

        Path mazeFile = Path.of("src/main/java/org/example/fromtibyan/sprint3/maze.txt");

        ArrayList<String> mazeArray = (ArrayList<String>) Files.readAllLines(mazeFile);

        // convert to 2d array
        char[][] mazeArray2D = new char[10][10];
        for (int i = 0; i < mazeArray.size(); i++) {
            mazeArray2D[i] = mazeArray.get(i).toCharArray();
        }
        if (onlyOneSymbol(mazeArray2D) && allBordersOnes(mazeArray2D)){
            for (char[] row : mazeArray2D) {
                System.out.println(row);
            }
        }else {
            System.out.println("Border conditions are not met.");
        }






    }


    public static boolean onlyOneSymbol(char[][] mazeArray2D){
        //checking if there is one @ and one E
        int atCounter = 0;
        for (int row = 0; row<10;row++ ){
            for(int column = 0 ; column<10; column++){
                if (mazeArray2D[row][column] == '@') {
                    atCounter++;
                    if (atCounter>1){
                        return false;
                    }
                }
                if (mazeArray2D[row][column] == 'E') {
                    atCounter++;
                    if (atCounter>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean allBordersOnes(char[][] mazeArray2D){
        // maze borders condition of all 1s
        int index ;
        for (index = 0; index < 10; index++) {
            char columnCellFirst = mazeArray2D[0][index];
            char columnCellLast = mazeArray2D[9][index];
            char rowCellFirst = mazeArray2D[index][0];
            char rowCellLast = mazeArray2D[index][9];
            if (columnCellFirst == '1' || columnCellFirst == '@' || columnCellFirst == 'E') {
                if (columnCellLast == '1' || columnCellLast == '@' || columnCellLast == 'E') {
                    if (rowCellFirst == '1' || rowCellFirst == '@' || rowCellFirst == 'E') {
                        if (rowCellLast == '1' || rowCellLast == '@' || rowCellLast == 'E') {
                            return true;
                        }
                    }
                }

            }
        }return false;
    }

}
