package assessment;

public class Palindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2)
            return true;
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            while (i < s.length() && !(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))))
                i++;
            while (j >= 0 && !(Character.isAlphabetic(s.charAt(j)) || Character.isDigit(s.charAt(j))))
                j--;
            if (i < s.length() && j >= 0 && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome("eeccccbebaeeabebcccee"));
    }
}
