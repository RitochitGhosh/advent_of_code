import java.io.*;
import java.util.*;

public class CeresSearch {

    public static void main(String[] args) throws IOException {
        List<String> grid = readFile("data.txt");
        char[][] wordSearch = convertToGrid(grid);
        String target = "XMAS";

 
        int count = countOccurrences(wordSearch, target);

        System.out.println("Total occurrences of XMAS: " + count);
    }

    private static List<String> readFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    private static char[][] convertToGrid(List<String> grid) {
        int rows = grid.size();
        int cols = grid.get(0).length();
        char[][] wordSearch = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            wordSearch[i] = grid.get(i).toCharArray();
        }
        return wordSearch;
    }

    private static int countOccurrences(char[][] grid, String target) {
        int rows = grid.length;
        int cols = grid[0].length;
        int wordLength = target.length();
        int count = 0;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
            {-1, -1},
            {-1, 1},
            {1, -1},
            {1, 1}
        };

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (int[] dir : directions) {
                    if (canFindWord(grid, target, r, c, dir[0], dir[1], wordLength)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean canFindWord(char[][] grid, String target, int row, int col, int dRow, int dCol, int length) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < length; i++) {
            int newRow = row + i * dRow;
            int newCol = col + i * dCol;

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || grid[newRow][newCol] != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
