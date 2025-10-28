package firstattempt;

class Solution_1716 {
    public int totalMoney(int n) {
        int sum = 0;
        int w = n/7;
        int d = n%7;

        for (int i = 1; i <= w; i++) sum += 28 + 7 * (i-1);
        for (int i = 0; i < d; i++) sum += (w + 1) + i;

        return sum;
    }
}

public class Exercise_1716 {
    public static void main(String[] args) {
        Solution_1716 s = new Solution_1716();
        System.out.println(s.totalMoney(4));
        System.out.println(s.totalMoney(10));
        System.out.println(s.totalMoney(20));
        System.out.println(s.totalMoney(26));
    }
}
