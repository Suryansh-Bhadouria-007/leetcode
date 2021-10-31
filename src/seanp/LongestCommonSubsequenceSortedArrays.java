package seanp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestCommonSubsequenceSortedArrays {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int cnt[] = new int[101];
        for (var arr : arrays)
            for (var n : arr)
                ++cnt[n];
        return IntStream.range(0, 101).filter(i -> cnt[i] == arrays.length).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LongestCommonSubsequenceSortedArrays longestCommonSubsequenceSortedArrays = new LongestCommonSubsequenceSortedArrays();
        int arrays[][] = {{1, 3, 4}, {1, 4, 7, 9}};
        List<Integer> l = longestCommonSubsequenceSortedArrays.longestCommonSubsequence(arrays);
        l.stream().forEach(System.out::println);
    }
}
