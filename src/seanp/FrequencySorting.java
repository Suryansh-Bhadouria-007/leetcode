package seanp;


import java.util.Map;
import java.util.TreeMap;

public class FrequencySorting {
    class CustomChar implements Comparable {
        Character ch;
        int count;

        public CustomChar(Character ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(Object o) {
            CustomChar that = (CustomChar) o;
            if (this.ch == that.ch)
                return 0;
            if (this.count == that.count)
                return Character.compare(this.ch, that.ch);
            return that.count - this.count;
        }
    }

    public String frequencySort(String s) {
        TreeMap<CustomChar, CustomChar> customCharTreeSet = new TreeMap<>();
        for (char ch : s.toCharArray()) {
            CustomChar newCustomChar = new CustomChar(ch, 1);
            CustomChar orig = customCharTreeSet.get(newCustomChar);
            if (orig != null) {
                customCharTreeSet.remove(orig);
                orig.count++;
                customCharTreeSet.put(orig, orig);
            } else
                customCharTreeSet.put(newCustomChar, newCustomChar);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<CustomChar, CustomChar> entry : customCharTreeSet.entrySet()) {
            CustomChar key = entry.getKey();
            for (int i = 0; i < key.count; i++)
                sb.append(key.ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FrequencySorting frequencySorting = new FrequencySorting();
        System.out.println(frequencySorting.frequencySort("tree"));
    }
}
