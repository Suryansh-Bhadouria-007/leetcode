package seanp;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        List<String> paranthesis = new ArrayList<>();
        StringBuilder start = new StringBuilder();
        backtrack(start, 0, 0, n, paranthesis);
        return paranthesis;
    }

    private void backtrack(StringBuilder cur, int open, int close, int n, List<String> output) {
        if (cur.length() == n * 2) {
            output.add(cur.toString());
            return;
        }

        if (open < n) {
            cur.append("(");
            backtrack(cur, open + 1, close, n, output);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(cur, open, close + 1, n, output);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParanthesis gp = new GenerateParanthesis();
        List<String> l = gp.generateParenthesis(3);
        l.stream().forEach(System.out::println);
    }
}