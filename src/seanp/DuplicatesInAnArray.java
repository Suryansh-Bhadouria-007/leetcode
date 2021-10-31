package seanp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesInAnArray {
    public static void main(String[] args) {
        int nums[] = {4, 3, 2, 7, 8, 2, 3, 1};
        DuplicatesInAnArray di = new DuplicatesInAnArray();
        System.out.println(di.findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int i : nums) {
            if (seen.contains(i))
                result.add(i);
            seen.add(i);
        }
        return result;
    }
}
