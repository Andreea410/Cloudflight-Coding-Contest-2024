import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Level3 {
    public static void main1(String[] args) {
        String inputFilePath = "E:\\EXTRAS FOR CV\\CCC\\TRAINING\\LAWN MOWER\\level3\\level3_5.in";
        String outputFilePath = "E:\\EXTRAS FOR CV\\CCC\\TRAINING\\LAWN MOWER\\level3\\outputLevel3_5.txt";

        try (Scanner scanner = new Scanner(new File(inputFilePath))) {
            int numberOfTestCases = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
                for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
                    int n = scanner.nextInt();
                    int m = scanner.nextInt();
                    scanner.nextLine();

                    char[][] matrix = new char[m][n];

                    // Read the matrix
                    for (int i = 0; i < m; i++) {
                        String line = scanner.nextLine();
                        matrix[i] = line.toCharArray();
                    }

                    String path = scanner.nextLine();
                    boolean isValidPathFound = false;

                    for (int startX = 0; startX < m; startX++) {
                        for (int startY = 0; startY < n; startY++) {
                            if (matrix[startX][startY] == 'X' || matrix[startX][startY] == '*') {
                                continue;
                            }

                            char[][] tempMatrix = new char[m][n];
                            for (int i = 0; i < m; i++) {
                                System.arraycopy(matrix[i], 0, tempMatrix[i], 0, n);
                            }

                            tempMatrix[startX][startY] = '*';
                            int x = startX;
                            int y = startY;
                            boolean isValid = true;

                            for (char direction : path.toCharArray()) {
                                if (direction == 'W') x--;
                                else if (direction == 'S') x++;
                                else if (direction == 'A') y--;
                                else if (direction == 'D') y++;

                                if (x < 0 || x >= m || y < 0 || y >= n || tempMatrix[x][y] == 'X' || tempMatrix[x][y] == '*') {
                                    isValid = false;
                                    break;
                                }

                                tempMatrix[x][y] = '*';
                            }
                            if (isValid) {
                                for (int i = 0; i < m; i++) {
                                    for (int j = 0; j < n; j++) {
                                        if (tempMatrix[i][j] == '.') {
                                            isValid = false;
                                            break;
                                        }
                                    }
                                }
                            }

                            if (isValid) {
                                isValidPathFound = true;
                                break;
                            }
                        }
                        if (isValidPathFound) {
                            break;
                        }
                    }
                    writer.println(isValidPathFound ? "VALID" : "INVALID");
                }
            } catch (IOException e) {
                System.err.println("An error occurred while writing to the file: " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
