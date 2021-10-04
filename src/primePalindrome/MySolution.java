package primePalindrome;

public class MySolution {
    public static void main(String[] args) {
        MySolution mySolution=new MySolution();
        int i = mySolution.primePalindrome(1);
        System.out.println(i);
    }
    public int primePalindrome(int n) {
        for (int i = n; i<= Integer.MAX_VALUE; i++) {
            if (isPalindrome(i) && isPrime(i))
                return i;
        }
        return -1;
    }

    private boolean isPalindrome(int n) {
        char chars[] = String.valueOf(n).toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {
            if (chars[i] != chars[j])
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

//    private boolean isPalindrome(int num){
//
//        int reversedNum = 0, remainder;
//        int originalNum = num;
//        while (num != 0) {
//            remainder = num % 10;
//            reversedNum = reversedNum * 10 + remainder;
//            num /= 10;
//        }
//        return (originalNum == reversedNum);
//    }

    private boolean isPrime(int n) {
        if(n==1)
            return false;
        int count = 0;
        for (int i = 1; i <= (n / 2); i++) {
            if (n % i == 0)
                count++;
            if (count > 2)
                return false;
        }
        return count == 1;
    }
}
