import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LEVEL4 {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "";
        String outputFilePath = "";
        PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath));

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line = br.readLine();
            int N = Integer.parseInt(line.trim());

            for (int roomIndex = 0; roomIndex < N; roomIndex++) {
                line = br.readLine();
                String[] parts = line.split(" ");
                int m = Integer.parseInt(parts[0]);
                int n = Integer.parseInt(parts[1]);
                int deskCount = Integer.parseInt(parts[2]);

                char[][] room = new char[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        room[i][j] = '.';
                    }
                }
                int desksPlaced = 0;

                for (int i = 0; i < n && desksPlaced < deskCount; i += 2) {
                    for (int j = 0; j < m && desksPlaced < deskCount; j += 3) {
                        if (j + 1 < m) {
                            room[i][j] = 'X';
                            room[i][j + 1] = 'X';
                            desksPlaced++;
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        writer.print(room[i][j]);
                    }
                    writer.println();
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
