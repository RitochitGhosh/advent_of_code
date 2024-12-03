import java.io.*;
import java.util.regex.*;

public class CorruptedMemory {
    public static void main(String[] args) {
        String filePath = "data.txt";
        StringBuilder corruptedMemory = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                corruptedMemory.append(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        String memory = corruptedMemory.toString();
        Pattern mulPattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        Pattern controlPattern = Pattern.compile("(do\\(\\)|don't\\(\\))");

        int totalSumAll = 0;
        int totalSumEnabled = 0;
        boolean isEnabled = true;

        Matcher mulMatcher = mulPattern.matcher(memory);
        Matcher controlMatcher = controlPattern.matcher(memory);

        int currentIndex = 0;
        while (mulMatcher.find()) {
            int x = Integer.parseInt(mulMatcher.group(1));
            int y = Integer.parseInt(mulMatcher.group(2));
            totalSumAll += x * y;

            while (controlMatcher.find(currentIndex) && controlMatcher.start() < mulMatcher.start()) {
                String control = controlMatcher.group();
                isEnabled = control.equals("do()");
                currentIndex = controlMatcher.end();
            }

            if (isEnabled) {
                totalSumEnabled += x * y;
            }
        }

        System.out.println("Total Sum of All Valid Multiplications: " + totalSumAll);
        System.out.println("Total Sum of Enabled Multiplications: " + totalSumEnabled);
    }
}