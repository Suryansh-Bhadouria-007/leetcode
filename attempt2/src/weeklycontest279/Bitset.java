package weeklycontest279;

import java.util.stream.IntStream;

public class Bitset {
    private byte bitset[];
    private int size;
    private int oneCount;

    public Bitset(int size) {
        this.size = size;
        this.oneCount = 0;
        this.bitset = new byte[size];
    }

    public void fix(int idx) {
        if (idx < 0 || idx > this.size)
            System.out.println("invalid index");
        if (this.bitset[idx] == 0)
            this.oneCount++;
        this.bitset[idx] = 1;

    }

    public void unfix(int idx) {
        if (idx < 0 || idx > this.size)
            System.out.println("invalid index");
        if (this.bitset[idx] == 1)
            this.oneCount--;
        this.bitset[idx] = 0;
    }

    public void flip() {
        for (int i = 0; i < this.size; i++) {
            if (this.bitset[i] == 1) {
                this.bitset[i] = 0;
            } else {
                this.bitset[i] = 1;
            }
        }
        this.oneCount = this.size - this.oneCount;
    }

    public boolean all() {
        return this.oneCount == this.size;
    }

    public boolean one() {
        return this.oneCount > 0;
    }

    public int count() {
        return this.oneCount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, this.size).forEach(i -> sb.append(bitset[i]));
        return sb.toString();
    }
}