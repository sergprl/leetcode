package firstattempt;

import java.util.*;

public class exercise_966 {
    // O(n)
    public static String hash(String str) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        StringBuilder sb = new StringBuilder(str.toLowerCase());

        for(int i = 0; i < sb.length(); i++) {
            if (vowels.contains(sb.charAt(i))) sb.setCharAt(i, '&');
        }

        return sb.toString();
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        // check for exact match
        Set<String> allWords = new HashSet<>(Arrays.asList(wordlist));
        String[] result = new String[queries.length];

        for(int i = 0; i < queries.length; i++)
            if(allWords.contains(queries[i])) result[i] = queries[i]; else result[i] = "";

        // check for matching case
        Map<String, String> mapCase = new HashMap<>();
        for(String word : wordlist) {
            String lowerCase = word.toLowerCase();
            if (!mapCase.containsKey(lowerCase))
                mapCase.put(lowerCase, word);
        }

        for(int i = 0; i < queries.length; i++) {
            if(result[i].isEmpty()) {
                String lowerCase = queries[i].toLowerCase();
                result[i] = mapCase.getOrDefault(lowerCase, "");
            }
        }

        // check for matching of preferred
        Map<String, String> map = new HashMap<>();
        for (String word : wordlist) {
            String hash = hash(word);
            if (!map.containsKey(hash)) {
                map.put(hash, word);
            }
        }

        for(int i = 0; i < queries.length; i++) {
            if(result[i].isEmpty()) {
                String hash = hash(queries[i]);
                result[i] = map.getOrDefault(hash, "");
            }
        }


        return result;
    }

    public static void main(String[] args) {
        String[] wordlist = new String[] {"zeo","Zuo"};
        String[] queries = new String[] {"zuo"};

        for(String result : spellchecker(wordlist, queries))
            System.out.print("\"" + result + "\"" + " ");
    }
}
