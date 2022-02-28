package daily;

import java.util.Arrays;

public class HomogenousSubstrings {

    private int ways[];

    public HomogenousSubstrings(int l) {
        ways = new int[l + 1];
        Arrays.fill(ways, -1);
        ways[0] = 0;

    }

    private int getWays(String s, String sb, int currentIndex, int length) {
        if (sb.length() == length)
            return 1;
        if (currentIndex > length)
            return 0;
        if (ways[currentIndex] == -1)
            ways[currentIndex] = getWays(s, sb + (s.charAt(currentIndex - 1)), currentIndex + 1, length)
                    + getWays(s, sb, currentIndex + 1, length);
        return ways[currentIndex];
    }

    public static void main(String[] args) {
        String s = "aaa";
        HomogenousSubstrings homogenousSubstrings = new HomogenousSubstrings(3);
        int ways = homogenousSubstrings.getWays(s, new String(), 1, 3);
        System.out.println(ways);
    }
}
