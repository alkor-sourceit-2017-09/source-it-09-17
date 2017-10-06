public class Task5 {
    public static String convert(int columnNum) {
        columnNum--;
        StringBuilder sb = new StringBuilder();
        while (columnNum > -1) {
            sb.append((char) (columnNum % 26 + 65));
            columnNum = columnNum / 26 - 1;
        }
        return sb.reverse().toString();
    }

    public static int convert(String column) {
        column = column.toUpperCase();
        int result = 0;
        int k = 0;
        for (int i = column.length() - 1; i >= 0; i--) {
            result += (column.charAt(i) - 64) * Math.pow(26, k++);
        }
        return result;
    }

    public static String getNext(String column) {
        StringBuilder sb = new StringBuilder(column.toUpperCase());
        char lastChar = sb.charAt(column.length() - 1);
        if (lastChar + 1 > 'Z') {
            sb.append("A");
        } else {
            sb.replace(column.length() - 1, column.length(), String.valueOf((char) (lastChar + 1)));
        }
        return sb.toString();
    }
}
