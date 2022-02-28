package seanp;

import java.util.*;

public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        // Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
        int N = org.length;
        int[] indegree = new int[N + 1];
        // Topological sort
        Map<Integer, Set<Integer>> decendents = new HashMap<>();
        Set<Integer> numberSet = new HashSet<>();
        for (List<Integer> seq : seqs) {
            numberSet.addAll(seq);
            for (int i = 0; i < seq.size() - 1; i++) {
                // seq.get(i) -> seq.get(i+1)
                Set<Integer> next = decendents.getOrDefault(seq.get(i), new HashSet<>());
                // avoid indegree caculation wrong
                if (!next.contains(seq.get(i + 1))) {
                    if (seq.get(i + 1) > N || seq.get(i + 1) < 0) {
                        return false;
                    }
                    indegree[seq.get(i + 1)]++;
                    next.add(seq.get(i + 1));
                    decendents.put(seq.get(i), next);
                }

            }
        }

        if (numberSet.size() != N) {
            return false;
        }
        Queue<Integer> myQueue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0 && numberSet.contains(i)) {
                myQueue.add(i);
            }
        }
        int index = 0;
        while (!myQueue.isEmpty()) {
            int size = myQueue.size();
            if (size > 1) {
                return false;
            }
            int number = myQueue.poll();
            if (org[index++] != number) {
                return false;
            }
            for (int neighbor : decendents.getOrDefault(number, new HashSet<>())) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    myQueue.add(neighbor);
                }
            }
        }

        if (index < N) {
            return false;
        }
        return true;
    }
}
