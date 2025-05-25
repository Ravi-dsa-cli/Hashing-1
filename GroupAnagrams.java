import java.util.*;

//Sort Each Word: Convert each word to a character array, sort it, and use the sorted string as a key.
//
//Group by Key: Use a HashMap<String, List<String>> to store lists of words that share the same sorted key.
//
//Return Groups: Return all values from the map as the final result.
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);

            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());
    }

    // Main method for testing
    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = sol.groupAnagrams(input);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
