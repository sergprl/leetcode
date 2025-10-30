package firstattempt;

import java.util.ArrayList;
import java.util.List;

class Solution_1526 {
    public int minNumberOperations(int[] target) {
        int mountains = 0;
        int valleys = 0;

        for (int i = 0; i < target.length ; i++) {
            int left = i == 0 ? 0 : target[i-1];
            int right = i == (target.length - 1) ? 0 : target[i+1];

            while (i != target.length-1 && right == target[i]) {
                i++;
                right = i == (target.length - 1) ? 0 : target[i+1];
            }

            if (target[i] > left && target[i] > right) {
                mountains += target[i];
            } else if (target[i] < left && target[i] < right) {
                valleys += target[i];
            }
        }

        return mountains - valleys;
    }
}

public class Exercise_1526 {
    public static void main(String[] args) {
        Solution_1526 s = new Solution_1526();
        System.out.println(s.minNumberOperations(new int[] {3,1,1,2}));
    }
}
