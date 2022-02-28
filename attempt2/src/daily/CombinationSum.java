package daily;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> combinations;
    private int candidates[];
    private int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.combinations = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        backtrack(0, 0, new ArrayList<>());
        return combinations;
    }

    private void backtrack(int currentIndex, int currentSum, List<Integer> currentList) {
        if (currentSum > target)
            return;
        if (currentSum == target)
            combinations.add(currentList);
        if (currentIndex >= candidates.length)
            return;
        for (int i = currentIndex; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            backtrack(i, currentSum + candidates[i], new ArrayList<>(currentList));
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int candidates[] = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = combinationSum.combinationSum(candidates, target);
        lists.forEach(System.out::println);
    }
}
