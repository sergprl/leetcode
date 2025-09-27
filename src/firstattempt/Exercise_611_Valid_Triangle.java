package firstattempt;

import com.sun.source.tree.BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution_611 {
    public int triangleNumber(int[] nums) {
        int length = nums.length;
        if(length < 3) return 0;

        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println();

        int counter = 0;
//        int first = 0;
//        int second = 1;
//        int third = 2;
//
        for(int first = 0; first < length-2; first++) {
            for(int second = first + 1; second < length - 1; second++){
                for(int third = second + 1; third < length; third++) {
                    if(nums[first] + nums[second] > nums[third])
                        counter++;
                }
            }
        }

//        while(first <= length-3) {
//            while(second < length-1 && (nums[first] + nums[second] > nums[third])){
//                while (third < length && (nums[first] + nums[second] > nums[third])){
//                    System.out.printf("[%d, %d, %d]%n", nums[first], nums[second], nums[third]);
//                    counter++;
//                    third++;
//                }
//                second++;
//                third = second + 1;
//            }
//            first++;
//            second = first + 1;
//            third = second + 1;
//        }
        return counter;
    }
}

public class Exercise_611_Valid_Triangle {

    public static void main(String[] args) {
        Solution_611 s = new Solution_611();

        int[] nums = new int[] {24,3,82,22,35,84,19};

        System.out.println("Possible triangles: " + s.triangleNumber(nums));


    }

}
