package firstattempt;

public class exercise_3446 {
    public static void sortUpperDiagonal(int[][] grid) {
        if(grid[0][1] > grid[1][2]){
            int temp = grid[0][1];
            grid[0][1] = grid[1][2];
            grid[1][2] = temp;
        }
    }

    public static void sortLowerDiagonal(int[][] grid) {
        if(grid[2][1] > grid[1][0]){
            int temp = grid[2][1];
            grid[2][1] = grid[1][0];
            grid[1][0] = temp;
        }
    }

    public static void sortMiddleDiagonal(int[][] grid) {
        int temp = 0;
        if(grid[0][0] < grid[1][1]) {
            temp = grid[1][1];
            grid[1][1] = grid[0][0];
            grid[0][0] = temp;
        }

        if(grid[0][0] < grid[2][2]) {
            temp = grid[2][2];
            grid[2][2] = grid[0][0];
            grid[0][0] = temp;
        }

        if(grid[1][1] < grid[2][2]) {
            temp = grid[2][2];
            grid[2][2] = grid[1][1];
            grid[1][1] = temp;
        }
    }

    public static void sortMatrix(int[][] grid) {
        sortUpperDiagonal(grid);
        sortLowerDiagonal(grid);
        sortMiddleDiagonal(grid);
    }

    public static void printMatrix(int[][] grid) {
        for(int[] i : grid) {
            for(int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] result = new int[][] {{1,7,3},{9,8,2}, {4,5,6}};
        printMatrix(result);
        System.out.println();

        sortMatrix(result);
        printMatrix(result);

    }
}
