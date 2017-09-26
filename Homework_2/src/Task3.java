public class Task3 {
    public static final String[] MONTHS = new String[]{"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};

    public static String getMonthById(int id) throws MonthNotFoundException {
        try {
            return MONTHS[id - 1];
        } catch (ArrayIndexOutOfBoundsException r) {
            throw new MonthNotFoundException("Month not exist");
        }
    }
}
