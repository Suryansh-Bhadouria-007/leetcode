import java.util.Stack;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class MaximumSwap {
    public static void main(String[] args) {
        MaximumSwap ms = new MaximumSwap();
        System.out.println(ms.maximumSwap(98368));
    }

    public int maximumSwap(int num) {
        char chars[] = String.valueOf(num).toCharArray();
        Stack<Entry<Integer, Integer>> stack = new Stack<>();
        SimpleEntry<Integer, Integer> dummyItem = new SimpleEntry<>(Integer.MAX_VALUE, -1);
        stack.push(dummyItem);

        Entry<Integer, Integer> maxRight
                = new SimpleEntry<>(chars.length - 1, Integer.valueOf(chars[chars.length - 1] + ""));
        for (int i = chars.length - 2; i >= 0; i--) {
            Integer current = Integer.valueOf(chars[i] + "");
            if (current < maxRight.getValue()) {
                stack.push(maxRight);
            } else {
                stack.push(dummyItem);
            }
            maxRight = current > maxRight.getValue() ?
                    new SimpleEntry<>(i, Integer.valueOf(chars[i] + "")) : maxRight;
        }
        for (int i = 0; i < chars.length; i++) {
            Entry<Integer, Integer> peek = stack.peek();
            Integer current = Integer.valueOf(chars[i] + "");
            if (peek.getValue() > current) {
                char tmp = Character.forDigit(peek.getValue(), 10);
                chars[peek.getKey()] = Character.forDigit(current, 10);
                chars[i] = tmp;
                break;
            }
            stack.pop();
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
