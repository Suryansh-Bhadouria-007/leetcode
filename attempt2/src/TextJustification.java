//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class TextJustification {
//    public List<String> fullJustify(String[] words, int maxWidth) {
//        List<String> output = new ArrayList<>();
//        for (int i = 0; i < words.length; ) {
//            int j = i;
//            int segmentLength = 0;
//            int numberOfWordsInLine = 0;
//            for (; j < words.length; j++) {
//                if (segmentLength + words[j].length() + 1 > maxWidth)
//                    break;
//                segmentLength += words[j].length() + 1;
//                numberOfWordsInLine++;
//            }
//            if (numberOfWordsInLine == 1) {
//                int spaces = maxWidth - words[i].length();
//                String res = words[i] + getBlanksString(spaces);
//                output.add(res);
//                i = j;
//                continue;
//            }
//            int extraSpaces = maxWidth - segmentLength;
//
//            int spaces[] = new int[numberOfWordsInLine - 1];
//            Arrays.fill(spaces, 1);
//
//            if ((extraSpaces & 1) == 1) {
//
//            }
//
//        }
//    }
//
//    private String getBlanksString(int len) {
//        StringBuilder sb = new StringBuilder();
//        while (len-- > 0)
//            sb.append(" ");
//        return sb.toString();
//    }
//}
