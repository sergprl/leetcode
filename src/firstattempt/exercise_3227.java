package firstattempt;

import java.util.*;

public class exercise_3227 {
    public static LinkedList<Boolean> transform2Bool(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        s = s.toLowerCase();
        LinkedList<Boolean> list = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i))) list.add(true);
            else list.add(false);
        }

        return list;
    }

    public static void printList(List<Boolean> list) {
        for(boolean a: list) {
            if (a) System.out.print("1");
            else System.out.print("0");
        }
        System.out.println();
    }

    public static boolean deletionMade(boolean odd, LinkedList<Boolean> list) {
        // if odd, start with false, if even, start with true
        boolean result;
        if (!list.isEmpty()) {
            result = !odd;
        } else {
            return false;
        }

        int currentIndex = 0;
        int lastIndex = -1;
        for (boolean bool : list) {
            result ^= bool;
            if (result) {
                lastIndex = currentIndex;
            }
            currentIndex++;
        }

        if (lastIndex != -1) {
            for(int i = 0; i <= lastIndex; i++) {
                list.removeFirst();
            }
            System.out.println(list);
            return true;
        }

        System.out.println(list);
        return false;
    }

    public static boolean play(String str) {
        LinkedList<Boolean> list = transform2Bool(str);
        boolean odd = true;
        boolean winnerFound = false;

        while(!winnerFound) {
            if(deletionMade(odd, list)) odd = !odd;
            else winnerFound = true;
        }

        return !odd;
    }

    public static void main(String[] args) {
        String str = "oddddd";
        boolean oddWins = play(str);
        System.out.printf("Result for %s is %s (%b)!%n", str, oddWins ? "Odd wins" : "Even wins", oddWins);
//        System.out.println(deletionMade(true, transform2Bool(str)));
//        System.out.println(deletionMade(false, transform2Bool("er")));
    }
}
