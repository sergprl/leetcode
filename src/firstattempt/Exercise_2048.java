package firstattempt;

import java.util.HashMap;
import java.util.Map;

class Solution_2048 {
    private Map<Integer, Integer> findFrequencies(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        String str = String.valueOf(n);
        for(int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i)-'0', map.getOrDefault(str.charAt(i)-'0', 0)+1);
        }

        return map;
    }

    public int nextBeautifulNumber(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        n++;

        System.out.println(findFrequencies(n));

        return 0;
    }
}

public class Exercise_2048 {

    public static void main(String[] args) {
        Solution_2048 s = new Solution_2048();
        s.nextBeautifulNumber(10);

    }

}
