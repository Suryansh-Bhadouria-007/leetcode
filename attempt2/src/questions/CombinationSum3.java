package questions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    private List<List<Integer>> combinations;
    private int k;
    private int n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.combinations = new ArrayList<>();
        if (k > n)
            return this.combinations;
        this.k = k;
        this.n = n;
        backtrack(0, 0, new ArrayList<>());
        return combinations;

    }

    private void backtrack(int currentVal, int currentSum, List<Integer> currentList) {
        if (currentSum > n)
            return;
        if (currentList.size() > k)
            return;
        if (currentSum == n && currentList.size() == k) {
            combinations.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = currentVal + 1; i <= 9; i++) {
            currentList.add(i);
            backtrack(i, currentSum + i, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        List<List<Integer>> lists = combinationSum3.combinationSum3(3, 9);
        lists.forEach(System.out::println);
    }
}
