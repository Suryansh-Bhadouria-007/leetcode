package daily;

public class DailyCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1)
            return true;
        boolean isFirstLetterCapital = word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
        if (!isFirstLetterCapital) {
            return areAllLettersSmall(word.substring(1));
        } else {
            return areAllLettersCapitals(word.substring(1)) || areAllLettersSmall(word.substring(1));
        }
    }

    private boolean areAllLettersCapitals(String str) {
        for (char ch : str.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z')
                continue;
            else
                return false;
        }
        return true;
    }

    private boolean areAllLettersSmall(String str) {
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                continue;
            else
                return false;
        }
        return true;
    }
}
