package questions;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == 1 && k > 0)
            return "0";
        int i = 0, j = 1;
        int countDeleted = 0;
        char nums[] = num.toCharArray();

        for (; i < nums.length && j < nums.length && countDeleted < k; ) {
            if (nums[i] == 'a') {
                i++;
                continue;
            }
            int first = Integer.parseInt(String.valueOf(nums[i]));
            int second = Integer.parseInt(String.valueOf(nums[j]));
            if (first >= second) {
                if (second == 0 && i == 0) {
                    nums[i] = 'a';
                    nums[i + 1] = 'a';
                    i += 2;
                    countDeleted += 2;

                } else {
                    nums[i] = 'a';
                    int temp_i = i;
                    for (; i >= 0; i--)
                        if (nums[i] != 'a')
                            break;
                    if (i == -1)
                        i = temp_i;
                    countDeleted += 1;
                }
            } else {
                i++;
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < nums.length; l++)
            if (Character.isDigit(nums[l]))
                sb.append(nums[l]);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        String s = removeKDigits.removeKdigits("112", 1);
        System.out.println("result string is: " + s);
    }
}
