package firstattempt;

public class CountingValleys {
    public static int countingValleys(int steps, String path) {
        int height = 0;
        int valleys = 0;
        for(int i = 0; i < steps; i++) {
            if(path.charAt(i) == 'U') height++;
            else {
                if (height == 0) valleys++;
                height--;
            }
        }

        return valleys;
    }

    public static void main(String[] args) {
        String path1 = "DDUUUUDD";
        String path2 = "UDDDUDUU";

        System.out.println(countingValleys(path2.length(), path2));
    }
}
