import java.io.*;
import java.util.*;

public class HistorianHysteria {

    public static List<List<Integer>> parseInputFile(String filename) throws IOException {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isBlank()) {
                    String[] parts = line.trim().split("\\s+");
                    list1.add(Integer.parseInt(parts[0]));
                    list2.add(Integer.parseInt(parts[1]));
                }
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        return List.of(list1, list2);
    }

    public static int calculateTotalDistance(List<Integer> list1, List<Integer> list2) {
        int totalDistance = 0;
        for (int i = 0; i < list1.size(); i++) {
            totalDistance += Math.abs(list1.get(i) - list2.get(i));
        }
        return totalDistance;
    }

    public static int calculateSimilarityScore(List<Integer> list1, List<Integer> list2) {
        int similarityScore = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for (int num: list2) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        for (int num: list1) {
            similarityScore += num * mp.getOrDefault(num, 0);
        }

        return similarityScore;
    }

    public static void main(String[] args) {
        String filename = "data.txt";

        try {
            List<List<Integer>> lists = parseInputFile(filename);
            List<Integer> list1 = lists.get(0);
            List<Integer> list2 = lists.get(1);

            int totalDistance = calculateTotalDistance(list1, list2);
            int similarityScore = calculateSimilarityScore(list1, list2);

    
            System.out.println("Total Distance: " + totalDistance);
            System.out.println("Similarity Score: " + similarityScore);

        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }
}
