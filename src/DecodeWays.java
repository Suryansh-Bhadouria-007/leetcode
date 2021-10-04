public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        dw.numDecodings("226");
    }

    public int numDecodings(String s) {
        int count = 0;
        System.out.println(countValidDecodes(s, 0));
        return count;
    }

    private int countValidDecodes(String s, int index) {
        if (index >= s.length())
            return 1;
        if (s.charAt(index) == '0')
            return 0;
        int validDecodeWithTwo = 0;

        if (index + 1 < s.length()) {
            int currentPlusTwo = Integer.parseInt(s.charAt(index) + "" + s.charAt(index + 1));
            if (currentPlusTwo >= 10 && currentPlusTwo <= 26) {
                validDecodeWithTwo = countValidDecodes(s, index + 2);
            }
        }
        return validDecodeWithTwo + countValidDecodes(s, index + 1);
    }


    private boolean isValidDecode(String s, int index) {
        if (index >= s.length())
            return true;
        if (s.charAt(index) == '0')
            return false;
        int currentPlusTwo = Integer.parseInt(s.charAt(index) + "" + s.charAt(index + 1));
        boolean validDecodeWithTwo = false;
        if (currentPlusTwo >= 10 && currentPlusTwo <= 26) {
            validDecodeWithTwo = isValidDecode(s, index + 2);
        }
        return validDecodeWithTwo || isValidDecode(s, index + 1);
    }
}
