import java.io.*;
import java.util.*;

public class SafetyReportChecker {

    public static boolean isIncreasing(List<Integer> list) {
        int len = list.size();
        for (int i = 0; i < len - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }

    public static boolean isDecreasing(List<Integer> list) {
        int len = list.size();
        for (int i = 0; i < len - 1; i++) {
            if (list.get(i) <= list.get(i + 1)) return false;
        }
        return true;
    }

    public static boolean isSafe(List<Integer> list) {
        // Check if the list is strictly increasing or decreasing
        boolean isIncreasing = isIncreasing(list);
        boolean isDecreasing = isDecreasing(list);
        if (!(isIncreasing || isDecreasing)) return false;

        // Check the difference condition
        int len = list.size();
        for (int i = 0; i < len - 1; i++) {
            int diff = Math.abs(list.get(i) - list.get(i + 1));
            if (diff < 1 || diff > 3) return false;
        }
        return true;
    }

    public static int safeCount(List<List<Integer>> reports) {
        int safeCount = 0;
        for (List<Integer> report : reports) {
            if (isSafe(report)) {
                safeCount++;
            }
        }
        return safeCount;
    }

    public static boolean isSafeWithDampener(List<Integer> list) {
        if (isSafe(list)) return true;

        int len = list.size();
        for (int i = 0; i < len; i++) {
            List<Integer> temp = new ArrayList<>(list);
            temp.remove(i);
            if (isSafe(temp)) {
                return true;
            }
        }
        return false;
    }

    public static int updatedSafeCount(List<List<Integer>> reports) {
        int safeCount = 0;
        for (List<Integer> report : reports) {
            if (isSafeWithDampener(report)) {
                safeCount++;
            }
        }
        return safeCount;
    }

    public static List<List<Integer>> readReports(String fileName) throws IOException {
        List<List<Integer>> reports = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.trim().split("\\s+");
                    List<Integer> report = new ArrayList<>();
                    for (String part : parts) {
                        report.add(Integer.parseInt(part));
                    }
                    reports.add(report);
                }
            }
        }
        return reports;
    }

    public static void main(String[] args) {
        try {
            String fileName = "data.txt";
            List<List<Integer>> reports = readReports(fileName);

            int safeReports = safeCount(reports);
            System.out.println("Number of safe reports: " + safeReports);

            int updatedSafeReports = updatedSafeCount(reports);
            System.out.println("Number of updated safe reports (with Problem Dampener): " + updatedSafeReports);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
