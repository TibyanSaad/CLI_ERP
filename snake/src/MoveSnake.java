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
        snakeBody.add(new int[]{7,9});// head initial position index 0
        snakeBody.add(new int[]{7,8});
        snakeBody.add(new int[]{7,7});
        snakeBody.add(new int[]{7,6});
        snakeBody.add(new int[]{7,5});


        for (int[] body : snakeBody) {
            mapArray2D[body[0]][body[1]] = 'o'; //draw start snake
        }

        // args[0] direction;
        // args[1]  steps;
        int steps = Integer.parseInt(args[1]);

        if (args[0].equalsIgnoreCase("up")){
            for (int move = 0; move < steps; move++) {
                int[] head = snakeBody.get(0);
                SnakePosition newHead = new SnakePosition(head[0] - 1, head[1]); // for each step update
                if (snakeNotOutside(newHead.hRow, newHead.hCol)) {
                    snakeBody.add(0, new int[]{newHead.hRow, newHead.hCol});// add new head value to arraylist
                    int[] oldTail = snakeBody.remove(snakeBody.size() - 1);// remove old tail from arraylist
                    mapArray2D[oldTail[0]][oldTail[1]] = '-';// remove old tail to show movement

                    for (int[] body : snakeBody) {
                        mapArray2D[body[0]][body[1]] = 'o'; // update map with snake body
                    }

                    displayMap(mapArray2D);
                }
            }
        }

        if (args[0].equalsIgnoreCase("down")){
            for (int move = 0; move < steps; move++) {
                int[] head = snakeBody.get(0);
                SnakePosition newHead = new SnakePosition(head[0] + 1, head[1]); // for each step update
                if (snakeNotOutside(newHead.hRow, newHead.hCol)) {
                    snakeBody.add(0, new int[]{newHead.hRow, newHead.hCol});// add new head value to arraylist
                    int[] tailEnd = snakeBody.remove(snakeBody.size() - 1);// remove old tail from arraylist
                    mapArray2D[tailEnd[0]][tailEnd[1]] = '-';// remove old tail to show movement

                    for (int[] body : snakeBody) {
                        mapArray2D[body[0]][body[1]] = 'o'; // update map with snake body
                    }

                    displayMap(mapArray2D);
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
}