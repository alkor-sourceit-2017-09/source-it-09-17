public class Task1 {
    public static long getDigitsSum(int a) {
        int result = 0;
        while (a > 0) {
            result += a % 10;
            a /= 10;
        }
        return result;
    }
}
