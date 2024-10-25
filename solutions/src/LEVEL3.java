import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LEVEL3 {
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

                int matrix[][] = new int[n][m];
                int j = 1;
                int ok = 3;
                for (int i = 0; i < n; i++) {
                    for (int k = 0; k < m && ok<m; k += 3)
                    {
                        ok+=3;
                        matrix[i][k] = j;
                        matrix[i][k+1] = j;
                        matrix[i][k+2] = j;
                        j++;
                    }
                }

                while(j < result)
                {
                    for(int i = 0;i < n;i++)
                        for(int k = 0;k < m;k++)
                            if(matrix[i][k] == 0 && i < n-2 && matrix[i+1][k] == 0 && matrix[i+2][k] == 0)
                            {
                                matrix[i+1][k] = j;
                                matrix[i+2][k] = j;
                                matrix[i][k] = j;
                                j++;
                            }
                            else if(matrix[i][k] == 0 && k< m-2 && matrix[i][k+1] == 0 && matrix[i][k+2] == 0)
                            {
                                matrix[i][k] = j;
                                matrix[i][k+2] = j;
                                matrix[i][k+1] = j;
                                j++;
                            }
                }
                for(int i = 0;i < n;i++)
                {
                    for(int k = 0;k < m;k++)
                    {
                        writer.printf("%d ",matrix[i][k]);
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
