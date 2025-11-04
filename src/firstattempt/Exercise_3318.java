package firstattempt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution_3318 {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = calculateXSumForSubarray(nums, i, i + k - 1, x);
        }

        return result;
    }

    private int calculateXSumForSubarray(int[] nums, int start, int end, int x) {
        final int MAX_VALUE = 50;
        int[] frequency = new int[MAX_VALUE + 1];
        int distinctCount = 0;

        int totalSum = 0;
        for (int i = start; i <= end; i++) {
            int num = nums[i];
            totalSum += num;
            if (frequency[num] == 0) {
                distinctCount++;
            }
            frequency[num]++;
        }

        if (distinctCount < x) {
            return totalSum;
        }

        int resultSum = 0;
        for (int selection = 0; selection < x; selection++) {
            int bestNumber = -1;
            int bestFrequency = -1;

            for (int number = MAX_VALUE; number >= 1; number--) {
                if (frequency[number] > bestFrequency) {
                    bestFrequency = frequency[number];
                    bestNumber = number;
                }
            }

            if (bestNumber != -1) {
                resultSum += bestNumber * bestFrequency;
                frequency[bestNumber] = 0;
            }
        }

        return resultSum;
    }
}

public class Exercise_3318 {
    public static void main(String[] args) {
        Solution_3318 s = new Solution_3318();

        System.out.println(Arrays.toString(s.findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2)));
    }
}
