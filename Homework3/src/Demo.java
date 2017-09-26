import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure " +
                "dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit" +
                " anim id est laborum.";

        Task1 wordCounter = new Task1(text, true);
        System.out.println("Smallest words: " + Arrays.toString(wordCounter.getSmallestWords()));
        System.out.println("Biggest words: " + Arrays.toString(wordCounter.getBiggestWords()));
    }
}
