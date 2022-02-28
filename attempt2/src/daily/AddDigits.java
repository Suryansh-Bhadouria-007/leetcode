package daily;

public class AddDigits {
    public int addDigits(int num) {
        String str = String.valueOf(num);
        while (str.length() > 1) {
            int val = 0;
            for (int i = 0; i < str.length(); i++) {
                val += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            str = String.valueOf(val);
        }
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        System.out.println(addDigits.addDigits(45));
    }
}
