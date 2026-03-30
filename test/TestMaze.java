package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class TestMaze {
    public static void main(String[] args) throws IOException, InterruptedException {

        Path mazeFile = Path.of("test/maze.txt");
        try {
            ArrayList<String> mazeArray = (ArrayList<String>) Files.readAllLines(mazeFile);

            // convert to 2d array
            char[][] mazeArray2D = new char[10][10];
            for (int i = 0; i < mazeArray.size(); i++) {
                mazeArray2D[i] = mazeArray.get(i).toCharArray();
            }
            if (allBordersOnes(mazeArray2D)){
                for (char [] maze : mazeArray2D){
                    System.out.println(maze);
                }


            }else {
                System.out.println("Border conditions are not met.");
            }


        } catch (IOException e) {
            System.err.println("Error reading the maze file: " + e.getMessage()); // misreading the file
        }
    }

    public static boolean allBordersOnes(char[][] mazeArray2D){
        // maze borders condition of all 1s
        int index ;
        for (index = 0; index < 10; index++) {
            char columnCellFirst = mazeArray2D[0][index];
            char columnCellLast = mazeArray2D[9][index];
            char rowCellFirst = mazeArray2D[index][0];
            char rowCellLast = mazeArray2D[index][9];
            if (!(columnCellFirst == '1' || columnCellFirst == '@' || columnCellFirst == 'E')) {
                return false;
            }
            if (!(columnCellLast == '1' || columnCellLast == '@' || columnCellLast == 'E')) {
                return false;
            }
            if (!(rowCellFirst == '1' || rowCellFirst == '@' || rowCellFirst == 'E')) {
                return false;
            }
            if (!(rowCellLast == '1' || rowCellLast == '@' || rowCellLast == 'E')) {
                return false;
            }
        }
        return true;
    }
}
