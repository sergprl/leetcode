package firstattempt;

class Solution_2125 {
    public int numberOfBeams(String[] bank) {
        int current = 0;
        int next = 0;
        int sum = 0;

        for(String row : bank) {
            for (char c : row.toCharArray()) {
                if (c == '1') next++;
            }
            if (next != 0) {
                sum += current * next;
                current = next;
                next = 0;
            }
        }
        return sum;
    }
}

public class Exercise_2125 {
    public static void main(String[] args) {
        Solution_2125 s = new Solution_2125();
        System.out.println(s.numberOfBeams(new String[] {"000","111","000"}));
    }

}
