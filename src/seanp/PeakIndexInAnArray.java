package seanp;

public class PeakIndexInAnArray {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int peakIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prev = mid - 1 >= 0 ? arr[mid - 1] : Integer.MIN_VALUE;
            int next = mid + 1 >= 0 ? arr[mid + 1] : Integer.MIN_VALUE;
            int curr = arr[mid];
            if (prev > curr && next < curr)
                high = mid - 1;
            else if (prev < curr && next > curr)
                low = mid + 1;
            else if (curr > prev && curr > next) {
                peakIndex = mid;
                break;
            }
        }
        return peakIndex;
    }

    public static void main(String[] args) {
        PeakIndexInAnArray piia = new PeakIndexInAnArray();
        int arr[] = {3, 5, 3, 2, 0};
        int index = piia.peakIndexInMountainArray(arr);
        System.out.println(index);
    }
}
