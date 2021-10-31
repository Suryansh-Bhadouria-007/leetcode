package seanp;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(4));
    }

    public int climbStairs(int n) {
        if (n < 3)
            return n;
        int twoBefore = 1;
        int oneBefore = 2;
        for (int i = 3; i <= n; i++) {
            int current = oneBefore + twoBefore;
            twoBefore = oneBefore;
            oneBefore = current;
        }
        return oneBefore;
    }
}
