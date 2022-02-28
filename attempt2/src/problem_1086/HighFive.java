package problem_1086;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class HighFive {
    private final int MAX_COUNT = 5;

    public int[][] highFive(int[][] items) {
        TreeMap<Integer, TreeMap<Integer, Integer>> studentVsScore = new TreeMap<>();
        for (int item[] : items) {
            int id = item[0];
            int currentScore = item[1];
            if (!studentVsScore.containsKey(id)) {
                studentVsScore.put(id, new TreeMap<>(Collections.reverseOrder()));
            }
            TreeMap<Integer, Integer> scoreVsFrequency = studentVsScore.get(id);
            if (scoreVsFrequency.containsKey(currentScore)) {
                scoreVsFrequency.put(currentScore, scoreVsFrequency.get(currentScore) + 1);
            } else
                scoreVsFrequency.put(currentScore, 1);
        }
        int studentAvgScore[][] = new int[studentVsScore.keySet().size()][2];
        int i = 0;
        for (Map.Entry<Integer, TreeMap<Integer, Integer>> entry : studentVsScore.entrySet()) {
            studentAvgScore[i][0] = entry.getKey();
            studentAvgScore[i++][1] = getAverageScore(entry.getValue());
        }
        return studentAvgScore;
    }

    private int getAverageScore(TreeMap<Integer, Integer> scoresVsFrequency) {
        int count = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : scoresVsFrequency.entrySet()) {
            Integer freq = entry.getValue();
            Integer score = entry.getKey();
            if ((count + freq) <= MAX_COUNT) {
                sum += freq * score;
                count += freq;
            } else if (count < MAX_COUNT) {
                sum += (MAX_COUNT - count) * score;
                count = MAX_COUNT;
            } else {
                break;
            }
        }
        return sum / count;
    }

    public static void main(String[] args) {
        int items[][] = {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}};
        HighFive hf = new HighFive();
        int[][] itemss = hf.highFive(items);
        for (int[] item : itemss) {
            System.out.println(item[0] + "," + item[1]);
        }

    }
}
