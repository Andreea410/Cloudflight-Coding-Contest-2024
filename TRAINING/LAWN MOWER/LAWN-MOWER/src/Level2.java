import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Level2 {
    public static void main(String[] args) {
        String inputFilePath = "E:\\EXTRAS FOR CV\\CCC\\TRAINING\\LAWN MOWER\\level2\\level2_5.in";
        String outputFilePath = "E:\\EXTRAS FOR CV\\CCC\\TRAINING\\LAWN MOWER\\level2\\outputLevel2_5.txt";

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
                        int x = 0, y = 0;
                        int minX = 0, maxX = 0, minY = 0, maxY = 0;

                        // Traverse the path string
                        for (int i = 0; i < str.length(); i++) {
                            char currentChar = str.charAt(i);
                            switch (currentChar) {
                                case 'W':
                                    y++;
                                    break;
                                case 'S':
                                    y--;
                                    break;
                                case 'A':
                                    x--;
                                    break;
                                case 'D':
                                    x++;
                                    break;
                            }

                            minX = Math.min(minX, x);
                            maxX = Math.max(maxX, x);
                            minY = Math.min(minY, y);
                            maxY = Math.max(maxY, y);
                        }

                        int width = maxX - minX + 1;
                        int height = maxY - minY + 1;

                        writer.printf("%d %d%n", width, height);
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
