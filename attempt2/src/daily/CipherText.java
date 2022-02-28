package daily;

public class CipherText {
    public String decodeCiphertext(String encodedText, int rows) {
        int sz = encodedText.length(), cols = sz / rows;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols; ++i)
            for (int j = i; j < sz; j += cols + 1)
                sb.append(encodedText.charAt(j));
        return sb.toString().stripTrailing();
    }

    public static void main(String[] args) {
        CipherText cipherText = new CipherText();
        System.out.println(cipherText.decodeCiphertext("ch   ie   pr", 3));
    }
}
