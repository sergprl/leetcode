package firstattempt;

class Solution_165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int maxLength = Math.max(v1.length, v2.length);

        for (int i = 0; i < maxLength; i++) {
            int value1 = v1.length <= i ? 0 : Integer.parseInt(v1[i]);
            int value2 = v2.length <= i ? 0 : Integer.parseInt(v2[i]);

            if(value1 > value2) return 1;
            else if (value1 < value2) return -1;
        }

        return 0;
    }
}

public class Exercise_165_Version_Numbers {
    public static void main(String[] args) {
        Solution_165 s = new Solution_165();

        String version1 = "1.2";
        String version2 = "1.10";

        System.out.printf("Result of comparing %s and %s is %d%n", version1, version2,
                s.compareVersion(version1, version2));

        version1 = "1.01";
        version2 = "1.001";

        System.out.printf("Result of comparing %s and %s is %d%n", version1, version2,
                s.compareVersion(version1, version2));

        version1 = "1.0";
        version2 = "1.0.0.0";

        System.out.printf("Result of comparing %s and %s is %d%n", version1, version2,
                s.compareVersion(version1, version2));

    }
}
