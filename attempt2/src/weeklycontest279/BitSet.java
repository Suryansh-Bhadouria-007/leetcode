package weeklycontest279;

import java.util.Arrays;

public class BitSet {
    char[] bitset, bitsetFlipped;
    int count = 0;
    boolean flipped = false;

    public BitSet(int size) {
        bitset = new char[size];
        bitsetFlipped = new char[size];
        Arrays.fill(bitset, '0');
        Arrays.fill(bitsetFlipped, '1');
    }

    public void fix(int idx) {
        count += (bitset[idx] == (flipped ? '1' : '0')) ? 1 : 0;
        bitset[idx] = (flipped ? '0' : '1');
        bitsetFlipped[idx] = (flipped ? '1' : '0');
    }

    public void unfix(int idx) {
        count -= (bitset[idx] == (flipped ? '0' : '1')) ? 1 : 0;
        bitset[idx] = (flipped ? '1' : '0');
        bitsetFlipped[idx] = (flipped ? '0' : '1');
    }

    public void flip() {
        flipped = !flipped;
        count = bitset.length - count;
    }

    public boolean all() {
        return count == bitset.length;
    }

    public boolean one() {
        return count != 0;
    }

    public int count() {
        return count;
    }

    public String toString() {
        return flipped ? new String(bitsetFlipped) : new String(bitset);
    }
}
