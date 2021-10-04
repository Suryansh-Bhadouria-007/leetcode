import java.util.HashSet;
import java.util.Set;

class CountSubs {
    public static void main(String[] args) {
        CountSubs cs=new CountSubs();
        System.out.println(cs.countSubstrings("aba","baba"));
    }
    public int countSubstrings(String s, String t) {
        //brute force
        int count = 0;
        Set<String> tSubstrings = new HashSet<>();
        for (int i = 0; i < t.length() - 1; i++) {
            for (int j = i + 1; j <= t.length(); j++) {
                char chars[] = t.substring(i, j).toCharArray();
                for (int k = 0; k < chars.length; k++) {
                    char ch = chars[k];
                    chars[k] = '*';
                    tSubstrings.add(new String(chars));
                    chars[k] = ch;
                }
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                char chars[] = s.substring(i, j).toCharArray();
                System.out.println("Processing :" + s.substring(i,j));
                for (int k = 0; k < chars.length; k++) {
                    char ch = chars[k];
                    chars[k] = '*';
                    String key = new String(chars);
                    if (tSubstrings.contains(key)) {
                        System.out.println("found "+key+" in "+tSubstrings);
                        count++;
                        tSubstrings.remove(key);
                        System.out.println("removed "+key+" from "+tSubstrings);
                    }
                    chars[k] = ch;
                }
            }
        }
        return count;
    }
}