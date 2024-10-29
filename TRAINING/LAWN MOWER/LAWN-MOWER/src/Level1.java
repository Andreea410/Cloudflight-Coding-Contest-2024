import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Level1 {
    public static void main(String[] args) {
        String inputFilePath = "E:\\EXTRAS FOR CV\\CCC\\TRAINING\\LAWN MOWER\\level1_5.in";
        String outputFilePath = "E:\\EXTRAS FOR CV\\CCC\\TRAINING\\LAWN MOWER\\outputLevel1_5.txt";

        try {
            Scanner scanner = new Scanner(new File(inputFilePath));
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                scanner.nextLine();

                String[] strings = new String[n];
                for (int i = 0; i < n; i++) {
                    if (scanner.hasNextLine()) {
                        strings[i] = scanner.nextLine();
                    }
                }
                try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
                    for (String str : strings) {
                        int w = 0, a = 0, d = 0, s = 0;

                        for (int i = 0; i < str.length(); i++) {
                            char currentChar = str.charAt(i);
                            if (currentChar == 'W') {
                                w++;
                            } else if (currentChar == 'A') {
                                a++;
                            } else if (currentChar == 'D') {
                                d++;
                            } else if (currentChar == 'S') {
                                s++;
                            }
                        }


                        writer.printf("%d %d %d %d%n", w, d, s, a);
                    }
                } catch (IOException e) {
                    System.err.println("An error occurred while writing to the file: " + e.getMessage());
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
