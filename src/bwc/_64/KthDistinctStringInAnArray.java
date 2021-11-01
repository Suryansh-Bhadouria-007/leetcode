package bwc._64;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class KthDistinctStringInAnArray {
    public String kthDistinct(String[] arr, int k) {
        String kthDistinctString = "";
        if (k > arr.length)
            return kthDistinctString;
        Set<String> seen = new HashSet<>();
        LinkedHashSet<String> distinct = new LinkedHashSet<>();
        for (String str : arr) {
            if (seen.contains(str))
                continue;
            if (distinct.contains(str)) {
                seen.add(str);
                distinct.remove(str);
            } else
                distinct.add(str);
        }
        if (distinct.size() >= k) {
            Iterator<String> iterator = distinct.iterator();
            while (iterator.hasNext() && k-- > 0) {
                kthDistinctString = iterator.next();
            }
        }
        return kthDistinctString;
    }
}
