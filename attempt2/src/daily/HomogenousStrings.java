package daily;

public class HomogenousStrings {
    public static int countHomogenous(String s) {
        int MOD = 1_000_000_007;
        char[] temp = s.toCharArray();
        long ans = 0;
        int i = 0;
        while (i < temp.length) {
            int j = i;
// Here if we find similar character then move on until we find different character
            while (i < temp.length && temp[i] == temp[j]) {
                i++;
            }
// Here u are counting total no of similar character
            long count = i - j;
            ans = ans + ((count * (count + 1)) / 2);

        }
        return (int) (ans % MOD);
    }

    public static int countHomogenous2(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int mod = 1_000_000_007;
        int count = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (s[i] == s[i - 1])
                count++;
            else
                count = 1;
            ans = (ans + count) % mod;
        }
        return ans;
    }

}
