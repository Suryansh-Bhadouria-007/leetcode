package questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {
    Map<String, List<Integer>> wordIndexListMap = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            List<Integer> indexList = wordIndexListMap.getOrDefault(wordsDict[i], new ArrayList<>());
            indexList.add(i);
            wordIndexListMap.put(wordsDict[i], indexList);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = wordIndexListMap.get(word1);
        List<Integer> list2 = wordIndexListMap.get(word2);
        int minDistance = Integer.MAX_VALUE;
        for (int i : list1) {
            for (int j : list2) {
                minDistance = Math.min(minDistance, Math.abs(i - j));
            }
        }
        return minDistance;
    }
}
