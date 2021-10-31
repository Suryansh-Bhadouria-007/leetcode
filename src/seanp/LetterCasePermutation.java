package seanp;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        letterCasePermUtil(result, s, new StringBuilder(), 0);
        return result;
    }

    private void letterCasePermUtil(List<String> result, String orig, StringBuilder ans, int index) {
        if (index >= orig.length()) {
            result.add(ans.toString());
            return;
        }
        char curr = orig.charAt(index);
        if (Character.isDigit(curr)) {
            ans.append(curr);
            letterCasePermUtil(result, orig, new StringBuilder(ans), index + 1);
        } else {
            letterCasePermUtil(result, orig, new StringBuilder(ans).append(curr), index + 1);
            if (Character.isLowerCase(curr)) {
                letterCasePermUtil(result, orig, new StringBuilder(ans).append((char) (curr - 32)), index + 1);
            } else {
                letterCasePermUtil(result, orig, new StringBuilder(ans).append((char) (curr + 32)), index + 1);
            }
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        List<String> result = letterCasePermutation.letterCasePermutation("a1b2");
        result.stream().forEach(x -> System.out.print(x + "\t"));
    }
}
