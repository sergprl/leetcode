package firstattempt;

import java.util.Arrays;

class Solution_3354 {
    private boolean foundValid(int[] nums, int curr, boolean goRight) {
        while (curr > -1 && curr < nums.length) {
            if (nums[curr] > 0) {
                nums[curr]--;
                goRight = !goRight;
            }
            if (goRight) curr++;
            else curr--;
        }

        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }

    public int countValidSelections(int[] nums) {
        int total = 0;

        for(int curr = 0; curr < nums.length; curr++) {
            if (nums[curr] == 0) {
                if(foundValid(Arrays.copyOf(nums, nums.length), curr, true)) total++;
                if(foundValid(Arrays.copyOf(nums, nums.length), curr, false)) total++;
            }
        }

        return total;
    }
}

public class Exercise_3354 {
    public static void main(String[] args) {
        Solution_3354 s = new Solution_3354();
        System.out.println(s.countValidSelections(new int[] {2,3,4,0,4,1,0}));
    }

}
