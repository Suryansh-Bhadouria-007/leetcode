package questions;

public class StringCompression {
    public int compress(char[] chars) {
        if (chars.length <= 1)
            return chars.length;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                sb.append(chars[i - 1]);
                if (count > 1)
                    sb.append(count);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(chars[chars.length - 1]);
        if (count > 1)
            sb.append(count);
        System.out.println(sb.toString());
        int ans = sb.length();
        for (int i = 0; i < ans; i++) {
            chars[i] = sb.charAt(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
//        char chars[] = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char chars[] = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};

        System.out.println(stringCompression.compress(chars));
    }
}
