package weekly_contest_276.problem2139;

public class MinimumMovesToReachTargetScore2 {

    public int minMoves(int target, int maxDoubles) {
        if (target == 1) return 0;
        int count = 0;
        while (target != 1) {
            if (target % 2 == 0 && maxDoubles != 0) {
                target = target / 2;
                maxDoubles--;
                count++;
            } else if (maxDoubles == 0) {
                count += target - 1;
                break;
            } else {
                target--;
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        MinimumMovesToReachTargetScore2 moves = new MinimumMovesToReachTargetScore2();
        int minMoves = moves.minMoves(19, 2);
        System.out.println(minMoves);
    }
}
