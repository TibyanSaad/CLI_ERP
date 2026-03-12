package test;


import java.util.Arrays;
import java.util.Stack;

public class star {
    public static void main(String[] args) {
        char [][] maze =  {
                {'1','1','1','1','1','1','1','1','1','1'},
                {'@','0','0','0','0','0','0','0','0','1'},
                {'1','1','1','1','1','0','1','1','1','1'},
                {'1','0','0','1','1','0','0','0','0','1'},
                {'1','0','1','0','1','0','1','1','0','1'},
                {'1','0','1','0','0','0','0','1','0','1'},
                {'1','0','1','1','1','1','0','1','0','1'},
                {'1','0','0','0','0','1','0','1','1','1'},
                {'1','1','1','1','0','1','0','0','0','E'},
                {'1','1','1','1','1','1','1','1','1','1'}
        };
        int row = 0;
        int col = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (maze[i][j] == '@'){
                    row = j;
                    col = i;
                }
            }
        }System.out.println(row+" "+col);

        //solution*************************

        //Stack<Character> mazePath = new Stack<>();

        for (int move=0;move<10;move++){
            if (maze[col+1][row] == '1' && maze[col-1][row] == '1'){
                //mazePath.push(maze[col+move][row]);
                for (int i = 0; i < maze.length; i++){
                    for (int j = 0; j < maze[i].length; j++){
                        maze[col+move][row] = '@';
                        System.out.print(maze[i][j]);}
                    System.out.println();}
            }//mazePath.pop();
        }


    }



}
