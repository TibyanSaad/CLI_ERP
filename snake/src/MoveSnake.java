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
        snakeBody.add(new int[]{7,9});// head initial position
        snakeBody.add(new int[]{7,8});
        snakeBody.add(new int[]{7,7});
        snakeBody.add(new int[]{7,6});
        snakeBody.add(new int[]{7,5});


        // getting head position
        int[] headPosition = snakeBody.get(0);
        int headRow = headPosition[0];
        int headColumn = headPosition[1];

        //getting body 1st part
        int[] b1 = snakeBody.get(1);
        int b1Row = b1[0];
        int b1Column = b1[1];

        //getting body 2nd part
        int[] b2 = snakeBody.get(2);
        int b2Row = b2[0];
        int b2Column = b2[1];

        //getting body 3rd part
        int[] b3 = snakeBody.get(3);
        int b3Row = b3[0];
        int b3Column = b3[1];

        // getting tail position
        int[] tail = snakeBody.get(0);
        int tailRow = tail[0];
        int tailColumn = tail[1];





        ArrayList<SnakePosition> snakeMovement = new ArrayList<>();
        SnakePosition headStart = new SnakePosition(headRow, headColumn);
        snakeMovement.add(headStart);
        SnakePosition head = headStart;


        // args[0] direction;
        // args[1]  steps;
        int steps = Integer.parseInt(args[1]);


        if (args[0].equalsIgnoreCase("up")){

            for (int move = 0; move < steps; move++) {
                SnakePosition newHead = new SnakePosition(head.hRow - 1, head.hCol); // for each step update
                if (snakeNotOutside(newHead.hRow, newHead.hCol)) {
                    snakeMovement.add(0,newHead); // add to arraylist
                    mapArray2D[newHead.hRow][newHead.hCol] = 'o';
                    mapArray2D[b1Row][b1Column] = 'o';
                    mapArray2D[b2Row][b2Column] = 'o';
                    mapArray2D[b3Row][b3Column] = 'o';
                    mapArray2D[tailRow][tailColumn] = 'o';

//                    SnakePosition tailend = snakeMovement.remove(snakeBody.size()-1); // remove tail
//                    mapArray2D[tailend.hRow][tailend.hCol] = '-';
//                    head = newHead; // new value of head
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
