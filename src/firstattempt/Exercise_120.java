package firstattempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int triangleSize;
        int penRow;
        int lastRow;
        int penRowSize;
        int option1;
        int option2;


        while(triangle.size() > 1) {
            triangleSize = triangle.size();
            penRow = triangleSize - 2;
            lastRow = triangleSize - 1;
            penRowSize = triangle.get(penRow).size();

            for(int i = 0; i < penRowSize; i++) {
                option1 = triangle.get(lastRow).get(i);
                option2 = triangle.get(lastRow).get(i+1);

                triangle.get(penRow).set(i,
                        triangle.get(penRow).get(i) + Math.min(option1, option2));
            }


            triangle.remove(lastRow);
        }

        return triangle.get(0).get(0);
    }

    public List<List<Integer>> arrayAsList(int[][] array) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < array.length; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < array[i].length; j++) {
                row.add(array[i][j]);
            }
            list.add(row);
        }

        return list;
    }


    public void printArray(int[][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class Exercise_120 {
    public static void main(String[] args) {
        Solution_120 s = new Solution_120();

        int[][] triangle1= new int[][] {{2}, {3,4}, {6,5,7}, {4,1,8,3}};

        s.printArray(triangle1);
        List<List<Integer>> triangle1List = s.arrayAsList(triangle1);
        System.out.println(triangle1List);

        System.out.println("Minimum total: " + s.minimumTotal(triangle1List));

    }

}



//List<List<Integer>> list = new ArrayList<>(Arrays.asList(
//        new ArrayList<>(Arrays.asList(1, 2, 3)),
//        new ArrayList<>(Arrays.asList(4, 5, 6)),
//        new ArrayList<>(Arrays.asList(7, 8, 9))
//));
