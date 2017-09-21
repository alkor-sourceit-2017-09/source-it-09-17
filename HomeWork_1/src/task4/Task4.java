package task4;

public class Task4 {
    private static int getNOD(int x, int y) {
        if (x == y) {
            return x;
        }
        return x > y ? getNOD(x - y, y) : getNOD(x, y - x);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Numbers count should be 2");
            System.exit(1);
        }

        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);

            if (x <= 0 || y <= 0) {
                System.out.println("Numbers should be positive");
                System.exit(1);
            }

            System.out.println("NOD: " + getNOD(x, y));
        } catch (NumberFormatException e) {
            System.out.println("Couldn't convert to integer");
        }
    }
}
