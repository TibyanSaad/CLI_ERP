package snake.src;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MoveSnake {

    public static void main(String[] args) throws InterruptedException {
        char[][] mapArray2D;
        ArrayList<String> mapArray;
        try {
            // read file
            Path snakeFile = Path.of(MoveSnake.class.getResource("./map.txt").toURI());
            mapArray = (ArrayList<String>) Files.readAllLines(snakeFile);
            mapArray2D = new char[mapArray.size()][mapArray.get(0).length()]; // create 2d array w/row and column size
            for (int i = 0; i < mapArray.size(); i++) {
                mapArray2D[i] = mapArray.get(i).toCharArray();// convert to char 2d array
            }
        } catch (URISyntaxException | IOException e) {
            System.err.println("ERROR READING FILE: " + e.getMessage()); // misreading the file
            throw new RuntimeException(e); // exception handling of toURI and reading file
        }

        for (char[] map : mapArray2D) {
            for (char space : map) {
                System.out.print(space + " ");
            }
            System.out.println();
        }

        ArrayList<int[]> snakeBody = new ArrayList<>();

// Read snake positions from the map (o = snake part)
        for (int i = 0; i < mapArray2D.length; i++) {
            for (int j = mapArray2D[i].length - 1; j >= 0; j--) { // right to left
                if (mapArray2D[i][j] == 'o') {
                    snakeBody.add(new int[]{i, j});
                }
            }
        }


        for (int[] body : snakeBody) {
            mapArray2D[body[0]][body[1]] = 'o'; //draw start snake
        }

        // args[0] direction;
        // args[1]  steps;
        int steps = Integer.parseInt(args[1]);

        if (args[0].equalsIgnoreCase("up")){
            for (int move = 0; move < steps; move++) {
                int[] head = snakeBody.get(0); // get current head location
                int newRow = head[0] - 1; // move up
                int newCol = head[1];// same column
                if (snakeNotOutside(newRow, newCol)) {
                    snakeBody.add(0, new int[]{newRow, newCol});// add new head at the front of the list
                    int[] oldTail = snakeBody.remove(snakeBody.size() - 1);// remove old tail to keep snake length constant
                    mapArray2D[oldTail[0]][oldTail[1]] = '-'; // remove old tail for movement
//                    for (int[] body : snakeBody) {
//                        mapArray2D[body[0]][body[1]] = 'o';// update the map with all snake parts
//                    }
                    writeMap(snakeBody,mapArray2D);
                    displayMap(mapArray2D);
                }
            }
        }

        if (args[0].equalsIgnoreCase("down")){
            for (int move = 0; move < steps; move++) {
                int[] head = snakeBody.get(0); // get current head location
                int[] beforeHead = snakeBody.get(1); // get current head location

                int newRow = head[0] + 1; // move up
                int newCol = head[1];// same column
                if (snakeNotOutside(newRow, newCol)) {
                    if(beforeHead[0]+1 != head[0]){
                        snakeBody.add(0, new int[]{newRow, newCol});// add new head at the front of the list
                        int[] tailEnd = snakeBody.remove(snakeBody.size() - 1);// remove old tail from arraylist
                        mapArray2D[tailEnd[0]][tailEnd[1]] = '-';// remove old tail to show movement

                        for (int[] body : snakeBody) {
                            mapArray2D[body[0]][body[1]] = 'o'; // update map with snake body
                        }
                        writeMap(snakeBody,mapArray2D);
                        displayMap(mapArray2D);
                    }
                }else {
                    System.out.println("cannot go down");
                }
            }
        }
    }

    //snake doesnt go out of map
    public static boolean snakeNotOutside(int headRow, int headColumn ){
        if (headRow >= 0 && headRow < 15 && headColumn >= 0 && headColumn < 15) {
            return true;
        }
        else {
            System.out.println("Snake hit the wall!");
            return false;
        }
    }

    //display map
    public static void displayMap(char[][] mapArray2D) throws InterruptedException {
        for (char[] row : mapArray2D) {
            for (char space : row) {
                System.out.print(space + " ");
            }
            System.out.println();
        }
        for (int space =0;space<10;space++){
            System.out.println();
        }
        Thread.sleep(1000);
    }

    // write to map.txt
    public static void writeMap(ArrayList<int[]> snakeBody, char[][] mapArray2D){
        // reset map except walls
        for (int i = 0; i < mapArray2D.length; i++) {
            for (int j = 0; j < mapArray2D[i].length; j++) {
                if (mapArray2D[i][j] != '#') {
                    mapArray2D[i][j] = '-';
                }
            }
        }

        // update snake positions
        for (int[] body : snakeBody) {
            mapArray2D[body[0]][body[1]] = 'o';
        }

        // write map to file (use relative path)
        Path snakeFile = Path.of("C:/Users/MOBPC/Desktop/New folder/CLI_ERP/snake/src/map.txt"); // change to your actual path
        List<String> mapLines = new ArrayList<>();
        for (char[] row : mapArray2D) {
            mapLines.add(new String(row));
        }

        try {
            Files.write(snakeFile, mapLines); // overwrite the file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}