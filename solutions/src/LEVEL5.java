import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LEVEL5 {
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
                int k = 3;
                if(m%2 == 1)
                {
                    if (n % 2 == 1)
                    {
                        for (int j = 0; j < m; j += 2) {
                            for (int i = 0; i < n - 1; i += 3) {
                                room[i][j] = 'X';
                                room[i + 1][j] = 'X';
                                desksPlaced++;
                            }
                        }
                        for (int j = 0; j + 2 < m; j += 3) {
                            room[n - 1][j] = 'X';
                            room[n - 1][j + 1] = 'X';
                            desksPlaced++;
                        }
                    }
                    else {
                        for (int j = 0; j + 3 < m; j += 2) {
                            for (int i = 0; i + 2 < n; i += 3) {
                                room[i][j] = 'X';
                                room[i + 1][j] = 'X';
                                desksPlaced++;
                            }
                        }
                        for(int i = 0; i < n;i+=2)
                        {
                            room[i][m-1] = 'X';
                            room[i][m-2] = 'X';
                            desksPlaced++;
                        }
                    }
                }
                else
                {
                    if(n%2 == 1)
                    {
                        for(int j = 0; j < m-3;j+=2)
                        {
                            for(int i = 0;i< n-1;i+=3)
                            {
                                room[i][j] = 'X';
                                room[i+1][j] = 'X';
                                desksPlaced++;
                            }
                        }
                        for(int i = 0;i<n;i+=2)
                        {
                            room[i][m-1] = 'X';
                            room[i][m-2] = 'X';
                            desksPlaced++;
                        }
                    }
                    else {
                        for (int j = 0; j < m - 3; j += 2) {
                            for (int i = 0; i + 2 < n; i += 3) {
                                room[i][j] = 'X';
                                room[i + 1][j] = 'X';
                                desksPlaced++;
                            }
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
