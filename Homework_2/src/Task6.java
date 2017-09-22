import java.util.HashSet;

public class Task6 {
    public static int[][] removeMaxedLines(int[][] matrix) {
        HashSet<Integer> removeRows = new HashSet<>();
        HashSet<Integer> removeCols = new HashSet<>();
        Integer max = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                int col = row[j];

                if (col > max) {
                    max = col;
                    removeRows.clear();
                    removeCols.clear();
                }

                if (col == max) {
                    removeRows.add(i);
                    removeCols.add(j);
                }
            }
        }

        int[][] result = new int[matrix.length - removeRows.size()][];
        int iRow = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (!removeRows.contains(i)) {
                int[] row = result[iRow++] = new int[matrix[i].length - removeCols.size()];
                int iCol = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    if (!removeCols.contains(j)) {
                        row[iCol++] = matrix[i][j];
                    }
                }
            }
        }

        return result;
    }
}
