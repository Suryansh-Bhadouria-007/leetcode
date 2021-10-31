package dynamicProgramming;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int downOneStep = 0;
        int downTwoStep = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            int temp = downOneStep;
            downOneStep = Math.min(downOneStep + cost[i - 1], downTwoStep + cost[i - 2]);
            downTwoStep = temp;
        }

        return downOneStep;
    }
}
