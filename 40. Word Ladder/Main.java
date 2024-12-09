import java.util.*;

public class Main {
    static Map<String, List<String>> map;
    static int size;

    static void fillEmpty(List<String> words) {
        for (int i = 0; i < size; i++) {
            String word = words.get(i);
            map.put(word, new ArrayList<>());
        }
    }

    static boolean isValidDiff(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                diff++;
            if (diff > 1)
                return false;
        }
        return true;
    }

    static void fillDictionary(List<String> words, int index) {

        for (int i = 0; i < size; i++) {
            String word1 = words.get(i);
            for (int j = i + 1; j < size; j++) {
                String word2 = words.get(j);
                if (isValidDiff(word1, word2)) {
                    map.get(word1).add(word2);
                    map.get(word2).add(word1);
                }
            }
        }
    }

    static int findDistance(String beginWord, String endWord) {

        Queue<String> q = new LinkedList<>();
        Map<String, Integer> dMap = new HashMap<>();
        q.add(beginWord);
        dMap.put(beginWord, 1);

        while (!q.isEmpty()) {
            String word = q.poll();
            int d = dMap.get(word);

            List<String> validWords = map.get(word);
            for (String validWord : validWords) {
                if (validWord.equals(endWord))
                    return d + 1;
                if (!dMap.containsKey(validWord)) {
                    dMap.put(validWord, d + 1);
                    q.add(validWord);
                }
            }
        }
        return 0;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(beginWord))
            wordList.add(beginWord);

        map = new HashMap<>();
        size = wordList.size();

        fillEmpty(wordList);
        fillDictionary(wordList, 0);

        return findDistance(beginWord, endWord);
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String cog = "cog";

        List<String> wordList = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladderLength(beginWord, cog, wordList));
    }
}
