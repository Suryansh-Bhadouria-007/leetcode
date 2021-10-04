public class VerifyAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = createOrderMap(order);
        for (int i = 0; i < words.length - 1; i++) {
            int j = i + 1;
            boolean currentPairCheck = checkPair(words[i], words[j], orderMap);
            if (!currentPairCheck) {
                return false;
            }
        }
        return true;
    }

    private int[] createOrderMap(String order) {
        int letterToIndexMap[] = new int[26];
        for (int i = 0; i < order.length(); i++) {
            letterToIndexMap[order.charAt(i) - 'a'] = i;
        }
        return letterToIndexMap;
    }

    private boolean checkPair(String word1, String word2, int letterToIndexMap[]) {
        int l1 = word1.length();
        int l2 = word2.length();
        int i = 0, j = 0;
        char ch1 = ' ', ch2 = ' ';
        while (i < l1 && j < l2) {
            if (word1.charAt(i) != word2.charAt(j)) {
                ch1 = word1.charAt(i);
                ch2 = word2.charAt(i);
                break;
            }
            i++;
            j++;
        }
        //word1 contains word2--invalid
        if (i < l1 && j == l2) {
            return false;
        }
        //word2 contains word1 || word2==word1
        if ((i == l1 && j < l2) || (i == l1 && j == l2)) {
            return true;
        }
        return isValidMapping(ch1, ch2, letterToIndexMap);
    }

    private boolean isValidMapping(char ch1, char ch2, int letterToIndexMap[]) {
        if (letterToIndexMap[ch1 - 'a'] < letterToIndexMap[ch2 - 'a']) {
            return true;
        }
        return false;
    }
}
