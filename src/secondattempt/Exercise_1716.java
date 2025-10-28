package secondattempt;

class Solution_1716 {
    public int totalMoney(int n) {
        int sum = 0;
        int w = n/7;
        int d = n%7;

        sum += w*28 + 7*w*(w-1)/2;
        sum += d*(w+1) + d*(d-1)/2;

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
