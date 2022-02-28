package questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        Map<String, List<Integer>> wordIndexListMap = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            List<Integer> indexList = wordIndexListMap.getOrDefault(wordsDict[i], new ArrayList<>());
            indexList.add(i);
            wordIndexListMap.put(wordsDict[i], indexList);
        }
        List<Integer> list1 = wordIndexListMap.get(word1);
        List<Integer> list2 = wordIndexListMap.get(word2);
        int minDiff = Integer.MAX_VALUE;
        for (int i : list1) {
            for (int j : list2) {
                minDiff = Math.min(minDiff, Math.abs(i - j));
            }
        }
        return minDiff;
    }
}
