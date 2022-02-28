package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {
    private final String delimiter = Character.toString((char) 257);
    private final String emptyList = Character.toString((char) 258);

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) return emptyList;

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append(delimiter);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s.equals(emptyList)) return new ArrayList();
        return Arrays.asList(s.split(delimiter, -1));
    }
}