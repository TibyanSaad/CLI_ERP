import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MoveSnake {

    public static void main(String[] args) {
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
            int snakeBodySize = 0;
        for (int row = 0; row < mapArray.size(); row++) {
            for (int column = 0; column < mapArray.get(0).length(); column++) {
                if (mapArray2D[row][column] == 'o') {
                    snakeBody.add(new int[]{row, column});// snake body saved into an array inside arraylist
                    snakeBodySize++;
                }
            }
        }

        for (int[] position : snakeBody){
            System.out.println(Arrays.toString(position));
        }

        // getting head position
        int[] head = snakeBody.get(0);
        int headRow = head[0];
        int headColumn = head[1];

//
//        // getting tail position
//        int[] tail = snakeBody.get(0);
//        int tailRow = tail[0];
//        int tailColumn = tail[1];
//
//        //getting body 1st part
//        int[] b1 = snakeBody.get(3);
//        int b1Row = b1[0];
//        int b1Column = b1[1];
//
//        //getting body 2nd part
//        int[] b2 = snakeBody.get(2);
//        int b2Row = b2[0];
//        int b2Column = b2[1];
//
//        //getting body 2nd part
//        int[] b3 = snakeBody.get(1);
//        int b3Row = b3[0];
//        int b3Column = b3[1];
//
//        //tail
//        System.out.print(tailRow+",");
//        System.out.println(tailColumn);
//
//        //body
//        System.out.print(b3Row+",");
//        System.out.println(b3Column);
//
//        System.out.print(b2Row+",");
//        System.out.println(b2Column);
//
//        System.out.print(b1Row+",");
//        System.out.println(b1Column);
//
//        //head
//        System.out.print(headRow+",");
//        System.out.println(headColumn);

        snakePosition headStart = new snakePosition(headRow, headColumn);
        Stack<snakePosition> snakeMovement = new Stack<>();
        snakeMovement.push(headStart);

        while (!snakeMovement.isEmpty() && snakeNotOutside(headRow,headColumn)){
            // args[0] ="direction";
            int steps = Integer.parseInt(args[1]);
            // args[1] ="steps";

            snakePosition current = snakeMovement.pop();
            int hR = current.hRow;
            int hC = current.hCol;

            if (args[0].equalsIgnoreCase("up")){
                    snakeMovement.push(new snakePosition(hR-steps,hC));
                    mapArray2D[hR][hC] = 'o';
                    //mapArray2D[tailRow-steps][tailColumn] = '-';


            }
            for (char[] map : mapArray2D) {
                for (char space : map) {
                    System.out.print(space + " ");
                }
                System.out.println();
            }
            System.out.println();
//            if (args[0].toLowerCase() == "down"){
//                snakeMovement.offer(new snakePosition(r+steps,c));
//            }
//            if (args[0].toLowerCase() == "left"){
//                snakeMovement.offer(new snakePosition(r,c-steps));
//            }
//            if (args[0].toLowerCase() == "right"){
//                snakeMovement.offer(new snakePosition(r,c+steps));
//            }
        }
    }
    public static boolean snakeNotOutside(int headRow, int headColumn ){
        if (headRow >= 0 && headRow < 15 && headColumn >= 0 && headColumn < 15) {
            return true;
        }
        else {
            System.out.println("Game Over: Snake hit the wall!");
            return false;
        }
    }
}
