import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapS2T = new HashMap<>();
        HashMap<Character, Character> mapT2S = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapS2T.containsKey(charS)) {
                if (mapS2T.get(charS) != charT) {
                    return false;
                }
            } else {
                if (mapT2S.containsKey(charT)) {
                    return false;
                }
                mapS2T.put(charS, charT);
                mapT2S.put(charT, charS);
            }
        }

        return true;
    }

    // Main method to test the isIsomorphic function
    public static void main(String[] args) {
        IsomorphicStrings sol = new IsomorphicStrings();

        String s1 = "addz", t1 = "etta";
        String s2 = "ptta", t2 = "zkkz";

        System.out.println("Isomorphic? " + sol.isIsomorphic(s1, t1)); // true
        System.out.println("Isomorphic? " + sol.isIsomorphic(s2, t2)); // true

    }
}
