import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Level4 {
    static char[][] lawn;
    static boolean[][] visited;
    static StringBuilder path;
    static int totalFreeCells;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[] directions = {'D', 'A', 'W', 'S'};
    static int cols, rows;

    public static void main(String[] args) throws FileNotFoundException {
        String inputFilePath = "E:\\EXTRAS FOR CV\\CCC\\TRAINING\\LAWN MOWER\\level4\\level4_1.in";
        String outputFilePath = "E:\\EXTRAS FOR CV\\CCC\\TRAINING\\LAWN MOWER\\level4\\outputLevel4_1.txt";

        try (Scanner scanner = new Scanner(new File(inputFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {

            int numberOfLawns = scanner.nextInt();
            scanner.nextLine();

            for (int lawnIndex = 0; lawnIndex < numberOfLawns; lawnIndex++) {
                cols = scanner.nextInt();
                rows = scanner.nextInt();
                scanner.nextLine();

                lawn = new char[rows][cols];
                visited = new boolean[rows][cols];
                path = new StringBuilder();

                for (int i = 0; i < rows; i++) {
                    lawn[i] = scanner.nextLine().toCharArray();
                }

                totalFreeCells = countFreeCells(lawn);

                boolean foundPath = false;
                for (int i = 0; i < rows && !foundPath; i++) {
                    for (int j = 0; j < cols && !foundPath; j++) {
                        if (lawn[i][j] == '.') {
                            resetVisitedArray();
                            path.setLength(0);

                            if (findPath(i, j, 1)) {
                                foundPath = true;
                                writer.print(path.toString());
                            }
                        }
                    }
                }

                if (!foundPath) {
                    writer.println("No valid path found.");
                } else {
                    writer.println();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean findPath(int x, int y, int steps) {

        if (steps == totalFreeCells) return true;

        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];

            if (isValidMove(newX, newY)) {
                path.append(directions[dir]);
                if (findPath(newX, newY, steps + 1)) {
                    return true;
                }
                path.deleteCharAt(path.length() - 1);
            }
        }

        visited[x][y] = false;
        return false;
    }

    static boolean isValidMove(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols && lawn[x][y] == '.' && !visited[x][y];
    }

    static int countFreeCells(char[][] lawn) {
        int count = 0;
        for (int i = 0; i < lawn.length; i++) {
            for (int j = 0; j < lawn[0].length; j++) {
                if (lawn[i][j] == '.') count++;
            }
        }
        return count;
    }

    static void resetVisitedArray() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }
    }
}
