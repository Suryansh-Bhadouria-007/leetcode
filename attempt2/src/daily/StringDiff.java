package daily;

public class StringDiff {
    public char findTheDifference(String s, String t) {
        int alphabet[] = new int[26];
        for (int i = 0; i < t.length(); i++) {
            alphabet[(t.charAt(i) - 97)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            alphabet[(s.charAt(i) - 97)]--;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > 0)
                return (char) ('a' + i);
        }
        return Character.MIN_VALUE;
    }
}
