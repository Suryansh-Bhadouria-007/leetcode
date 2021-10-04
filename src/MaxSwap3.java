public class MaxSwap3 {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int i = 1;
        for (i = 1; i < s.length(); i++) {
            if (s.charAt(i) > s.charAt(i - 1)) break;
        }

        if (i == s.length()) return num;

        int max = 0;
        int maxPosition = i;

        for (int j = i; j < s.length(); j++) {
            if (Character.getNumericValue(s.charAt(j)) >= max) {
                max = Character.getNumericValue(s.charAt(j));
                maxPosition = j;
            }
        }

        char[] c = s.toCharArray();

        for (int k = 0; k < c.length; k++) {
            if (Character.getNumericValue(c[k]) < max) {
                char temp = c[k];
                c[k] = c[maxPosition];
                c[maxPosition] = temp;
                break;
            }
        }
        return Integer.valueOf(String.valueOf(c));
    }
}
