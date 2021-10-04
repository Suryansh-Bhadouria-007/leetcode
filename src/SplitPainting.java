import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SplitPainting {
    class Colour {
        Set<Integer> components;
        Long colour;

        public Colour() {
            components = new HashSet<>();
            colour = 0l;
        }
    }

    public static void main(String[] args) {
        SplitPainting splitPainting=new SplitPainting();
        int segments[][]=new int[][]{{233,270,217},{285,296,368},{250,260,98},{152,208,496},{30,62,383},{161,176,26},{245,278,471},{272,278,30},{261,267,436},{96,114,305},{35,156,207},{62,290,292},{127,276,21},{42,257,337},{299,300,479},{134,187,343},{161,223,136},{203,220,344},{154,272,162},{38,43,235},{289,291,38},{276,283,260},{136,170,478},{179,292,36},{126,221,146},{81,194,427}};
        List<List<Long>> lists = splitPainting.splitPainting(segments);
        System.out.println(lists);
    }

    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> finalColours = new ArrayList<>();
        int length = -1;
        for (int segment[] : segments) {
            if (segment[1] > length)
                length = segment[1];
        }
        Colour colours[] = new Colour[length + 1];
        for (int i = 0; i < length; i++) {
            colours[i] = new Colour();
        }
        colours[0].colour = -1l;
        for (int segment[] : segments) {
            for (int i = segment[0]; i < segment[1]; i++) {
                colours[i].colour += segment[2];
                colours[i].components.add(segment[2]);
            }
        }
        Colour prevColour = colours[0];
        for (int i = 1; i < length; i++) {
            if (colours[i].colour == 0l) {
                prevColour = new Colour();
                prevColour.colour = 0l;
                continue;
            }
            if (colours[i].colour != prevColour.colour || !colours[i].components.equals(prevColour.components)) {
                int j = i + 1;
                for (; j < length; ) {
                    if (colours[j].colour == colours[i].colour && colours[j].components.equals(colours[i].components))
                        j++;
                    else
                        break;
                }
                List<Long> res = new ArrayList<>();
                res.add(Long.valueOf(i));
                res.add(Long.valueOf(j));
                res.add(colours[i].colour);
                finalColours.add(res);
                prevColour = colours[i];
                i = j - 1;
            }
        }
        return finalColours;
    }
}
