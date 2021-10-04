import java.util.LinkedList;

public class OceanViewBuildings {
    public int[] findBuildings(int[] heights) {
        LinkedList<Integer> ll = new LinkedList<>();
        int len = heights.length;
        if (len == 0) {
            return new int[0];
        }
        int index = len - 1;
        int maxHeight = heights[index];
        ll.add(index);
        index--;

        while (index >= 0) {
            if (heights[index] > maxHeight) {
                ll.addFirst(index);
                maxHeight = heights[index];
            }
            index--;
        }
        int[] array = ll.stream().mapToInt(i -> i).toArray();
        return array;
    }
}
