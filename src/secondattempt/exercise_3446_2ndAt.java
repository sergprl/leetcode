package secondattempt;

import java.util.Collections;
import java.util.LinkedList;

public class exercise_3446_2ndAt {
    public static void printMatrix(int[][] grid) {
        for(int[] i : grid) {
            for(int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static int[][] sortMatrix(int[][] grid) {
        int j = 0;
        int length = grid.length;

        LinkedList<Integer> big2Top = new LinkedList<>();
        LinkedList<Integer> small2Top = new LinkedList<>();

        for(int i = 0; i < length; i++) {
            j = 0;
            while(i+j < length) {
                int sum = i + j;
                big2Top.add(grid[sum][j]);
                if(i != 0)
                    small2Top.add(grid[j][sum]);
                j++;
            }

            Collections.sort(big2Top);
            Collections.sort(small2Top);

            j = 0;
            while(i+j < length) {
                int sum = i + j;
                grid[sum][j] = big2Top.removeLast();
                if(i != 0)
                    grid[j][sum] = small2Top.removeFirst();
                j++;
            }
        }

        return grid;
    }

    public static void main(String[] args) {
//        int[][] grid_l1 = new int[][] {{1}};
//        printMatrix(sortMatrix(grid_l1));

//        int[][] grid_l2 = new int[][] {{0,1},{1,2}};
//        printMatrix(sortMatrix(grid_l2));

//        int[][] grid_l3 = new int[][] {{1,7,3},{9,8,2}, {4,5,6}};
//        printMatrix(grid_l3);
//        System.out.println();
//        printMatrix(sortMatrix(grid_l3));

        int[][] grid_l4 = new int[][] {{1,7,3,2}, {9,8,2,1}, {4,5,6,5}, {4,5,7,1}};
        printMatrix(grid_l4);
        System.out.println();
        printMatrix(sortMatrix(grid_l4));

    }
}
