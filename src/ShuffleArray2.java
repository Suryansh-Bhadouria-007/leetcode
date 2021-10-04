import java.util.*;

public class ShuffleArray2 {
    private int[] array;
    private int[] original;

    private Random rand = new Random();

    private Map<Integer, Integer> getArrayCopy() {
        Map<Integer, Integer> asMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            asMap.put(i, array[i]);
        }
        return asMap;
    }

    public ShuffleArray2(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        Map<Integer, Integer> aux = getArrayCopy();

        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(original.length);
            while (!aux.containsKey(removeIdx)) removeIdx = rand.nextInt(original.length);
            Integer val = aux.get(removeIdx);
            array[i] = val;
            aux.remove(removeIdx);
        }

        return array;
    }
}