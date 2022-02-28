package questions;

public class CountAndSay {
    public String countAndSay(int n) {
        int j = 1;
        String countAndSay = "1";
        for (; j < n; j++) {
            countAndSay = getNextCountAndSay(countAndSay);
        }
        return countAndSay;
    }

    private String getNextCountAndSay(String countAndSay) {
        char chars[] = countAndSay.toCharArray();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                sb.append(count);
                sb.append(chars[i - 1]);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count);
        sb.append(chars[chars.length - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(4));
    }
}
