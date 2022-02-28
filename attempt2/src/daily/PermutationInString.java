package daily;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;

        int origFreq[] = getCharFreq(s1);
        int newFreq[] = new int[26];
        int ws = 0;
        int we = 0;
        while (we < s2.length()) {
            if (we - ws == s1.length()) {
                if (checkIfFrequenciesMatch(newFreq, origFreq)) {
                    return true;
                } else {
                    newFreq[s2.charAt(ws) - 'a']--;
                    ws++;
                }
            } else if (we - ws < s1.length()) {
                newFreq[s2.charAt(we) - 'a']++;
                we++;
            }
        }
        //check for the last substring
        if (we - ws == s1.length()) {
            if (checkIfFrequenciesMatch(newFreq, origFreq)) {
                return true;
            }
        }
        return false;
    }

    private int[] getCharFreq(String str) {
        int freq[] = new int[26];
        for (char ch : str.toCharArray()) {
            freq[ch - 'a']++;
        }
        return freq;
    }

    private boolean checkIfFrequenciesMatch(int freq[], int origFreq[]) {
        for (int i = 0; i < freq.length; i++) {
            if (origFreq[i] != freq[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationInString pis = new PermutationInString();
        System.out.println(pis.checkInclusion("adc", "dcda"));
    }
}
