package firstattempt;

import java.util.HashMap;
import java.util.Map;

class Frequency_Solution_3005 {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] f = new int[2];

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);

            int frequency = map.get(num);

            if(frequency > f[0]){
                f[0] = frequency;
                f[1] = 1;
            } else if (frequency == f[0])
            {
                f[1]++;
            }
        }


        return f[0] * f[1];
    }
}

public class Exercise_3005_Frequencies {

    public static void main(String[] args) {
        Frequency_Solution_3005 f = new Frequency_Solution_3005();

        int[] numbers = new int[] {1,2,3,4,5};
        System.out.println(f.maxFrequencyElements(numbers));
    }
}
