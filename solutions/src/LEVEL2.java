import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LEVEL2 {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "";
        String outputFilePath = "";
        PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath));
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length < 3) {
                    System.err.println("Invalid input line: " + line);
                    continue;
                }

                int[] numbers = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    numbers[i] = Integer.parseInt(parts[i]);
                }

                int m = numbers[0];
                int n = numbers[1];
                int result = numbers[2];

                int j = 1;
                for (int i = 0; i < n; i++) {
                    for (int k = 0; k < m; k += 3) {
                        writer.printf("%d %d %d ", j, j, j);
                        j++;
                    }
                    writer.printf("%n");
                }

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
