package assessment;

public class PalindromeWithAtmostOneRemoval {

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return validPalindromeUtilIterative(s.substring(i + 1, j + 1)) || validPalindromeUtilIterative(s.substring(i, j));
            }
        }
        return true;
    }

    private boolean validPalindromeUtilRecursive(String s) {
        if (s.length() <= 1)
            return true;
        if (s.charAt(0) == s.charAt(s.length() - 1))
            return validPalindromeUtilRecursive(s.substring(1, s.length() - 1));
        else
            return false;
    }

    private boolean validPalindromeUtilIterative(String s) {
        if (s.length() <= 1)
            return true;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeWithAtmostOneRemoval palindrome = new PalindromeWithAtmostOneRemoval();
        System.out.println(palindrome.validPalindrome("abca"));
    }
}
