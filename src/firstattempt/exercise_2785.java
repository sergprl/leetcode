package firstattempt;// the goal of this program is to re-arrange the vowels in a string so they are in ascending order based on their ASCII
// value

import java.util.*;

class Solution {
    public String solution1(String s) {
        final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        LinkedList<Character> vowelsFound = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(vowels.contains(c)) {
                vowelsFound.add(c);
            }
        }

        StringBuilder sb = new StringBuilder(s);
        Collections.sort(vowelsFound);

        for(int i = 0; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i))) {
                sb.setCharAt(i, vowelsFound.removeFirst());
            }
        }

        return sb.toString();
    }
}

class MySolution {
    final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));

    public String solution(String s) {
        Map<Integer, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i))) {
                map.put(i, s.charAt(i));
            }
        }
        System.out.println(map);
        StringBuilder sb = new StringBuilder(s);
        LinkedList<Character> foundVowels = new LinkedList<>(map.values());
        Collections.sort(foundVowels);
        for(int i : new TreeSet<Integer>(map.keySet())) {
            System.out.println(i);
            sb.setCharAt(i, foundVowels.removeFirst());
        }
        return sb.toString();
    }

}

public class exercise_2785 {
    public static void main(String[] args) {
//        firstattempt.MySolution s = new firstattempt.MySolution();
//        System.out.println(s.solution("jovcaBZuFNGORkENkQxlBESCGuvRYLxJCSZwHPpkHrTJwOwFSyMTOIVumkAAsfGgVHwWuAtrjcHgKDBdajYme"));

        Solution s = new Solution();
        System.out.println(s.solution1("jovcaBZuFNGORkENkQxlBESCGuvRYLxJCSZwHPpkHrTJwOwFSyMTOIVumkAAsfGgVHwWuAtrjcHgKDBdajYme"));

    }
}
