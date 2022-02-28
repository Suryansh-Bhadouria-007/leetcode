package problem_746;

import static java.lang.Math.min;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int moveUpCost[] = new int[cost.length + 1];
        moveUpCost[0] = 0;
        moveUpCost[1] = 10;
        for (int i = 2; i <= cost.length; i++) {
            moveUpCost[i] = (i < cost.length ? cost[i] : 0) + min(moveUpCost[i - 1], moveUpCost[i - 2]);
        }
        return moveUpCost[cost.length];
    }
}