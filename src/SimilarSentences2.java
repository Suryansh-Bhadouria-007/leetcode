import java.util.*;

class DSU {
    Map<String, String> representative;

    public DSU() {
        representative = new HashMap<>();
    }

    public DSU(List<List<String>> similarPairs) {
        representative = new HashMap<>();
        for (List<String> l : similarPairs) {
            representative.put(l.get(0), l.get(0));
            representative.put(l.get(1), l.get(1));
        }
    }

    String find(String u) {
        if (!representative.containsKey(u))
            return null;
        if (u.equals(representative.get(u)))
            return u;

        else {
            representative.put(u, find(representative.get(u)));
            return representative.get(u);
        }
    }

    void combine(String u, String v) {
        u = find(u);
        v = find(v);

        if (u.equals(v))
            return;

        else {
            representative.put(v, u);
        }
    }
}

public class SimilarSentences2 {
    public static boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length)
            return false;

        DSU dsu = new DSU(similarPairs);
        for (List<String> pair : similarPairs) {
            dsu.combine(pair.get(0), pair.get(1));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i]))
                continue;
            var p1 = dsu.find(sentence1[i]);
            var p2 = dsu.find(sentence2[i]);
            if ((p1 != null && p2 != null && !p1.equals(p2)) || (p1 == null || p2 == null))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String sentence1[] = {"I", "love", "leetcode"};
        String sentence2[] = {"I", "love", "onepiece"};
        List<List<String>> pairs = new ArrayList<List<String>>() {
            {
                add(Arrays.asList("manga", "hunterXhunter"));
                add(Arrays.asList("platform", "anime"));
                add(Arrays.asList("leetcode", "platform"));
                add(Arrays.asList("anime", "manga"));
            }
        };
        System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));
    }
}
