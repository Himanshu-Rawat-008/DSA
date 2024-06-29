import java.util.*;

public class Main {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String s = String.valueOf(sorted);

            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {

                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }

        }

        return new ArrayList<>(map.values());

    }

    public static void main(String[] args) {
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }
}
