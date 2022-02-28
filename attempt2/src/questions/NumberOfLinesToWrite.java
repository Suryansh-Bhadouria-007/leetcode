package questions;

public class NumberOfLinesToWrite {
    public int[] numberOfLines(int[] widths, String s) {
        char[] chars = s.toCharArray();
        int totalWidth = 0;
        int lines = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            totalWidth += widths[ch - 'a'];
            if (totalWidth == 100) {
                if (i != chars.length - 1)
                    totalWidth = 0;
                lines++;
            } else if (totalWidth >= 100) {
                totalWidth = widths[ch - 'a'];
                lines++;
            }
        }

        return new int[]{(totalWidth > 0 && totalWidth < 100) ? lines + 1 : lines, totalWidth};
    }

    public int[] numberOfLinesLC(int[] widths, String S) {
        int lines = 1, width = 0;
        for (char c : S.toCharArray()) {
            int w = widths[c - 'a'];
            width += w;
            if (width > 100) {
                lines++;
                width = w;
            }
        }

        return new int[]{lines, width};
    }


    public static void main(String[] args) {
        NumberOfLinesToWrite numberOfLinesToWrite = new NumberOfLinesToWrite();
        int widths[] = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "bbbcccdddaaa";
        int[] res = numberOfLinesToWrite.numberOfLines(widths, s);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
