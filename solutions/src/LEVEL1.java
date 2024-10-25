import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LEVEL1 {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "";
        String outputFilePath = "";
        PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath));
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length == 0) {
                    continue;
                }

                int[] numbers = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    numbers[i] = Integer.parseInt(parts[i]);
                }

                int result = 1;
                for (int number : numbers) {
                    result *= number;
                }
                result /= 3;
                writer.printf("%d%n", result);

                System.out.print("Processed row: ");
                for (int number : numbers) {
                    System.out.print(number + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        } finally {
            writer.close();
        }
    }
}