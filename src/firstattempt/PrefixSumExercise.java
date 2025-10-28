package firstattempt;

class Solution_PrefixSumExercise {
    public boolean hasEquilibriumPoint() {
        int[] nums = new int[] {3,4,8,-9,20,6};
        int totalSum = 0;
        int localSum = 0;

        for (int i = 0; i < nums.length; i++) totalSum += nums[i];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (0 == totalSum) return true;
            } else if (i == nums.length-1) {
                if (totalSum-nums[nums.length-1] == 0) return true;
            } else {
                localSum += nums[i-1];
                if(totalSum - localSum - nums[i] == localSum) return true;
            }
        }

        return false;
    }
}

public class PrefixSumExercise {
    public static void main(String[] args) {
        Solution_PrefixSumExercise s = new Solution_PrefixSumExercise();
        System.out.println(s.hasEquilibriumPoint());
    }

}
