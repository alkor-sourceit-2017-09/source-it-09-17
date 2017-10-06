package task3;

public class Task3 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Numbers count should be 2");
            System.exit(1);
        }

        try {
            System.out.printf("%s + %s = %d\n", args[0], args[1], Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
        } catch (NumberFormatException e) {
            System.out.println("Couldn't convert to integer");
        }
    }
}
