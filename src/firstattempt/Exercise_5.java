package firstattempt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_5 {
    public String longestPalindrome(String s) {
        Pattern pattern = Pattern.compile("(.).*\\1");
        Matcher matcher = pattern.matcher(s);

        String result = "";
        while (matcher.find()) {
            System.out.println(matcher.group());
            

            if(matcher.group().length() > result.length())
                result = matcher.group();
        }

        return result;
    }

    public static void main(String[] args) {
        Exercise_5 e = new Exercise_5();
        System.out.println("Result: " + e.longestPalindrome("radiohead"));
    }
}
