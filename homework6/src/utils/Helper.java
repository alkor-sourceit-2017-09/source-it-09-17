package utils;

import exception.CustomException;

public interface Helper {
    public static Object getElemByIndex(Object[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Integer parseString(String str) {
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void throwRT() {
        throw new RuntimeException("RT exception");
    }

    public static void throwE() throws CustomException {
        throw new CustomException("custom exception");
    }

    public static void hideRealE() throws CustomException {
        try {
            throw new IllegalArgumentException("hidden iae");
        } catch (IllegalArgumentException e) {
            // NOP
        } finally {
            throw new CustomException("should be thrown");
        }
    }

    public static Double getDouble(Object o) {
        try {
            return Double.parseDouble(o.toString());
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
