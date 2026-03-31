

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MoveSnake {

    public static void main(String[] args) throws InterruptedException, URISyntaxException {
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

        for (char[] row : mapArray2D) {
            for (char space : row) {
                System.out.print(space + " ");
            }
            System.out.println();
        }
        for (int space =0;space<10;space++){
            System.out.println();
        }

        ArrayList<int[]> snakeBody = new ArrayList<>();


        // Read snake positions from snakeCoordinates.txt
        try {
            List<String> coordinate = Files.readAllLines(Path.of("./snakeCoordinates.txt"));
            for (String sCoordinate : coordinate) {
                sCoordinate = sCoordinate.trim();

                // Split by comma
                String[] parts = sCoordinate.split(",");
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);

                snakeBody.add(new int[]{row, col});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int[] body : snakeBody) {
            mapArray2D[body[0]][body[1]] = 'o'; //draw start snake
        }

        for (int[] coord : snakeBody) {
            System.out.println(coord[0] + "," + coord[1]);
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
                    //mapArray2D[newRow][newCol] = 'o'; // add new head for movement
                    int[] oldTail = snakeBody.remove(snakeBody.size() - 1);// remove old tail to keep snake length constant
                    mapArray2D[oldTail[0]][oldTail[1]] = '-'; // remove old tail for movement
                    displayMap(mapArray2D,snakeBody);
                    writeMap(snakeBody,mapArray2D);
                    snakeTrackingFile(snakeBody);
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
    public static void displayMap(char[][] mapArray2D,ArrayList<int[]> snakeBody) throws InterruptedException {
        for (char[] row : mapArray2D) {
            for (char space : row) {
                System.out.print(space + " ");
            }
            System.out.println();
        }
        for (int[] coord : snakeBody) {
            System.out.println(coord[0] + "," + coord[1]);
        }
        for (int space =0;space<10;space++){
            System.out.println();
        }
        Thread.sleep(1000);
    }

    // write to map.txt
    public static void writeMap(ArrayList<int[]> snakeBody, char[][] mapArray2D) throws URISyntaxException {

        for (int[] body : snakeBody) {
            mapArray2D[body[0]][body[1]] = 'o';// update snake positions
        }
        Path snakeFile = Path.of(MoveSnake.class.getResource("./map.txt").toURI());// write map to file
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

    // to save the state of snake every run and keep track of head location
    public static void snakeTrackingFile(ArrayList<int[]> snakeBody){
        try {
            FileWriter writer = new FileWriter("./snakeCoordinates.txt");

            for (int[] snakeCoord : snakeBody) {
                // Write each coordinate pair tgt
                writer.write(snakeCoord[0] + "," + snakeCoord[1] + "\n");
            }
            System.out.println();

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

