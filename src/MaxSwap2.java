public class MaxSwap2 {
    public int maximumSwap(int num) {
        char s[] = String.valueOf(num).toCharArray();  // Converting the number to a string
        for (int i = 0; i < s.length; i++)  // finding all possible swaps
        {
            int k = i;
            char p = s[i];
            for (int j = i + 1; j < s.length; j++)  // find the most valued swap which can maximize the result
            {
                if (s[j] >= p) {
                    k = j;
                    p = s[j];
                }
            }
            if (k != i && s[k] != s[i])    //checking the condition and make the final swap
            {
                s = swap(s, k, i);
                break;
            }
        }

        return Integer.parseInt(new String(s));  // returning the number back
    }

    private char[] swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
        return s;
    }
}
