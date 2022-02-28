package weekly_contest_276.problem2139;

public class MinimumMovesToReachTargetScore {
    class Answer {
        int ans;

        public Answer() {
            this.ans = Integer.MAX_VALUE;
        }
    }

    public int minMoves(int target, int maxDoubles) {
        Answer answer = new Answer();
        minMovesUtil(1, target, maxDoubles, 0, answer);
        return answer.ans;
    }

    private void minMovesUtil(int start, int target, int maxDoubles, int moves, Answer answer) {
        if (start == target) {
            answer.ans = Math.min(moves, answer.ans);
            return;
        } else if (start > target)
            return;
        if (maxDoubles > 0) {
            minMovesUtil(start * 2, target, maxDoubles - 1, moves + 1, answer);
        }
        minMovesUtil(start + 1, target, maxDoubles, moves + 1, answer);
    }

    public static void main(String[] args) {
        MinimumMovesToReachTargetScore moves = new MinimumMovesToReachTargetScore();



        int minMoves = moves.minMoves(766972377, 92);
        System.out.println(minMoves);
    }
}
