package bwc._64;

import java.util.Arrays;
import java.util.PriorityQueue;

public class OverlappingEvents {
    public int maxTwoEvents(int[][] events) {
        int result = 0, maxOfCompletedEvents = 0;
        Arrays.sort(events, (x, y) -> x[0] - y[0]);   // Sort by Start time
        PriorityQueue<int[]> inProgressQueue = new PriorityQueue<>((x, y) -> x[1] - y[1]); // sorted by end time
        for (int[] currentEvent : events) {
            while (!inProgressQueue.isEmpty() && inProgressQueue.peek()[1] < currentEvent[0])
                maxOfCompletedEvents = Math.max(maxOfCompletedEvents, inProgressQueue.poll()[2]);
            result = Math.max(result, maxOfCompletedEvents + currentEvent[2]);
            inProgressQueue.offer(currentEvent);
        }
        return result;
    }

    public static void main(String[] args) {
        OverlappingEvents oe = new OverlappingEvents();
        int events[][] = {{1, 3, 2}, {4, 5, 4}, {5, 8, 7}};
        System.out.println(oe.maxTwoEvents(events));
    }
}
