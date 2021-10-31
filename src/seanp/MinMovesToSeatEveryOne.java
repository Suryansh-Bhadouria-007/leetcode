package seanp;

import java.util.Arrays;

//https://leetcode.com/contest/biweekly-contest-63/problems/minimum-number-of-moves-to-seat-everyone/
public class MinMovesToSeatEveryOne {
    public int minMovesToSeat(int[] seats, int[] students) {
        if ((seats == null && students == null) || (seats.length == 0 && students.length == 0))
            return 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }
}
