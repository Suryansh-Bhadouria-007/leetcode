public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        RemoveAdjacentDuplicates rad = new RemoveAdjacentDuplicates();
        System.out.println(rad.removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String s) {
        if (s.length() <= 1)
            return s;
        int indexS = 1;
        int indexSb = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (; indexS < s.length(); ) {
            char chS = s.charAt(indexS);
            char chSb = ' ';
            if (indexSb >= 0 && indexSb < sb.length())
                chSb = sb.charAt(indexSb);
            if (chS == chSb) {
                indexS++;
                if (chSb != ' ') {
                    sb.deleteCharAt(indexSb);
                    indexSb--;
                }
            } else {
                sb.append(chS);
                indexS++;
                indexSb++;
            }
        }
        return sb.toString();
    }
}
