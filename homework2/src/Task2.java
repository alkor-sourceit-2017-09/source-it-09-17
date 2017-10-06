import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {
    private static boolean isPalindromed(int number) {
        String num_str = Integer.toString(number);
        boolean result = true;
        for (int i = num_str.length() / 2; i > 0; i--) {
            if (num_str.charAt(i - 1) != num_str.charAt(num_str.length() - i)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int[] getPalindromNums(int[] numbers) {
        int[] result = null;
        if (numbers != null) {
            result = Arrays.stream(numbers).filter(Task2::isPalindromed).toArray();
        }
        return result != null ? result : new int[0];
    }
}
