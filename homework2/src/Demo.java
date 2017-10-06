import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        String delim = "----------";

        int num = 7776;
        System.out.println(MessageFormat.format("Digits sum of ''{0}'' is: {1}", num, Task1.getDigitsSum(num)));
        System.out.println(delim);

        int[] numArr = new int[]{1, 131, 444, 455254};
        System.out.println(MessageFormat.format("Palindroms from {0}: {1}",
                Arrays.toString(numArr), Arrays.toString(Task2.getPalindromNums(numArr))));
        System.out.println(delim);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter id of month to print: ");
        try {
            int monthId = sc.nextInt();
            System.out.println("Month successfully find: " + Task3.getMonthById(monthId));
        } catch (MonthNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("You should enter number");
        }
        System.out.println(delim);

        try {
            String test = "test";
            String algo = "md5";
            System.out.println(MessageFormat.format("''{0}'' crypted with {1}: ''{2}''",
                    test, algo, Task4.getCrypted(test, algo)));
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algo not found. Possible values are: sha-256, md5");
        }
        System.out.println(delim);

        String column = "a";
        System.out.println(MessageFormat.format("Column number for ''{0}'': ''{1}''", column, Task5.convert(column)));
        System.out.println(delim);

        int columnNum = 1;
        System.out.println(MessageFormat.format("Excel notation for column ''{0}'': ''{1}''",
                columnNum, Task5.convert(columnNum)));
        System.out.println(delim);

        column = "za";
        System.out.println(MessageFormat.format("Excel column after ''{0}'': ''{1}''", column, Task5.getNext(column)));
        System.out.println(delim);

        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {2, 5, 1, 1},
                {1, 2, 1, 1},
                {2, 4, 1, 1}
        };
        System.out.println(MessageFormat.format("Array before removing max: {0}", Arrays.deepToString(matrix)));
        System.out.println(MessageFormat.format("Array after removing max: {0}",
                Arrays.deepToString(Task6.removeMaxedLines(matrix))));
    }
}
