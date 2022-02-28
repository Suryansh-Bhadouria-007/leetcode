package weekly_contest_276;

import java.util.Arrays;

public class DivideString {
    public String[] divideString(String s, int k, char fill) {
        int inputStringSize = s.length();
        int outputSize = (inputStringSize % k == 0) ? (inputStringSize / k) : (inputStringSize / k + 1);
        String[] output = new String[outputSize];
        if (outputSize == 1)
            output[0] = s;
        int upperBound = -1;
        for (int i = 1; i < outputSize; i++) {
            int lowerBound = k * (i - 1);
            upperBound = k * i;
            output[i - 1] = s.substring(lowerBound, upperBound);
        }
        if (upperBound != -1)
            output[outputSize - 1] = s.substring(upperBound, inputStringSize);

        if (inputStringSize % k != 0) {
            StringBuilder sb = new StringBuilder(output[outputSize - 1]);
            int diff = outputSize * k - inputStringSize;
            for (int i = 0; i < diff; i++)
                sb.append(fill);
            output[outputSize - 1] = sb.toString();
        }
        return output;
    }

    public String[] divideString2(String s, int k, char fill) {
        int inputStringSize = s.length();
        int outputSize = (inputStringSize % k == 0) ? (inputStringSize / k) : (inputStringSize / k + 1);
        String[] output = new String[outputSize];
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        for (; i < inputStringSize; i++) {
            if (i != 0 && i % k == 0) {
                output[j++] = sb.toString();
                sb = new StringBuilder();
            }
            sb.append(s.charAt(i));
        }
        int length = sb.length();
        for (int iter = 0; iter < k - length; iter++)
            sb.append(fill);
        output[j] = sb.toString();
        return output;
    }


    public static void main(String[] args) {
        DivideString ds = new DivideString();
        String[] output = ds.divideString2("abcdefghi", 3, 'x');
        Arrays.stream(output).forEach(System.out::println);
    }
}
