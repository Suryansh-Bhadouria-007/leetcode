import java.util.*;

public class SimilarSentences {
    public static void main(String[] args) {
        String str1[] = {"an", "extraordinary", "meal"};
        String str2[] = {"one", "good", "dinner"};
        List<List<String>> pairs = new ArrayList<List<String>>() {
            {
                add(Arrays.asList("great", "good"));
                add(Arrays.asList("extraordinary", "good"));
                add(Arrays.asList("well", "good"));
                add(Arrays.asList("wonderful", "good"));
                add(Arrays.asList("excellent", "good"));
                add(Arrays.asList("fine", "good"));
                add(Arrays.asList("nice", "good"));
                add(Arrays.asList("any", "one"));
                add(Arrays.asList("some", "one"));
                add(Arrays.asList("unique", "one"));
                add(Arrays.asList("the", "one"));
                add(Arrays.asList("an", "one"));
                add(Arrays.asList("single", "one"));
                add(Arrays.asList("a", "one"));
                add(Arrays.asList("truck", "car"));
                add(Arrays.asList("wagon", "car"));
                add(Arrays.asList("automobile", "car"));
                add(Arrays.asList("auto", "car"));
                add(Arrays.asList("vehicle", "car"));
                add(Arrays.asList("entertain", "have"));
                add(Arrays.asList("drink", "have"));
                add(Arrays.asList("eat", "have"));
                add(Arrays.asList("take", "have"));
                add(Arrays.asList("fruits", "meal"));
                add(Arrays.asList("brunch", "meal"));
                add(Arrays.asList("breakfast", "meal"));
                add(Arrays.asList("food", "meal"));
                add(Arrays.asList("dinner", "meal"));
                add(Arrays.asList("super", "meal"));
                add(Arrays.asList("lunch", "meal"));
                add(Arrays.asList("possess", "own"));
                add(Arrays.asList("keep", "own"));
                add(Arrays.asList("have", "own"));
                add(Arrays.asList("extremely", "very"));
                add(Arrays.asList("actually", "very"));
                add(Arrays.asList("really", "very"));
                add(Arrays.asList("super", "very"));
            }
        };
        System.out.println(areSentencesSimilar(str1, str2, pairs));
    }

   /* public static boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length)
            return false;
        Map<String, String> pairs = new HashMap<>();
        for (int i = 0; i < similarPairs.size(); i++) {
            pairs.put(similarPairs.get(i).get(0), similarPairs.get(i).get(1));
//            pairs.put(similarPairs.get(i).get(1), similarPairs.get(i).get(0));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (!(sentence1[i].equals(sentence2[i])
                    || (pairs.containsKey(sentence1[i]) && pairs.get(sentence1[i]).equals(sentence2[i]))
                    || (pairs.containsKey(sentence2[i]) && pairs.get(sentence2[i]).equals(sentence1[i]))))
                return false;
        }
        return true;
    }*/

    public static boolean areSentencesSimilar(String[] sen1, String[] sen2, List<List<String>> similarPairs) {
        if (sen1.length != sen2.length) return false;

        var map = new HashMap<String, Set<String>>();
        for (var pair : similarPairs) {
            map.computeIfAbsent(pair.get(0),k -> new HashSet<String>()).add(pair.get(1));
            map.computeIfAbsent(pair.get(1),k -> new HashSet<String>()).add(pair.get(0));
        }

        for (int i = 0; i < sen1.length; i++) {
            if (sen1[i].equals(sen2[i])) continue;
            var similarWords = map.get(sen1[i]);
            System.out.print(sen1[i]+"--->");
            Arrays.stream(similarWords.toArray()).forEach(k->System.out.print(k+"\t"));
            System.out.println();
            if (similarWords == null || !similarWords.contains(sen2[i])) return false;
        }
        return true;
    }

}
