package weeklycontest279;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestNumber {
    public long smallestNumber(long num) {
        long result = 0;
        List<Long> digits = new ArrayList<>();
        long nums = num < 0 ? -1 * num : num;
        while (nums > 0) {
            long d = nums % 10;
            digits.add(d);
            nums /= 10;
        }

        if (num < 0) {
            digits.sort(Collections.reverseOrder());
        } else {
            Collections.sort(digits);
        }
        int nonZeroIndex = -1;
        if (num > 0 && digits.get(0) == 0 && digits.size() > 1) {
            for (int i = 0; i < digits.size(); i++) {
                if (digits.get(i) != 0) {
                    nonZeroIndex = i;
                    break;
                }
            }
        }

        if (nonZeroIndex != -1) {
            result += Math.pow(10, digits.size() - 1) * digits.get(nonZeroIndex);
            for (int i = 0; i < digits.size(); i++) {
                if (i != nonZeroIndex)
                    result += Math.pow(10, digits.size() - 1 - i) * digits.get(i);
            }
        } else {
            for (int i = 0; i < digits.size(); i++) {
                result += Math.pow(10, digits.size() - 1 - i) * digits.get(i);
            }
        }


        return (num < 0) ? (-1 * result) : result;
    }

    public static void main(String[] args) {
        SmallestNumber smallestNumber = new SmallestNumber();
        System.out.println(smallestNumber.smallestNumber(310));
    }
}
