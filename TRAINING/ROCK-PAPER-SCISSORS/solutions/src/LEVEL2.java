import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class LEVEL2 {
    public static void main(String[] args) {
        String inputFilePath = "E:\\EXTRAS FOR CV\\CCC\\TRAINING\\ROCK-PAPER-SCISSORS\\level2\\level1_5.in";
        String outputFilePath = "E:\\EXTRAS FOR CV\\CCC\\TRAINING\\ROCK-PAPER-SCISSORS\\level2\\outputlevel1_5.txt";

        try {
            Scanner scanner = new Scanner(new File(inputFilePath));
            PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath));
            int n;
            if(scanner.hasNextInt()) {
                n = scanner.nextInt();
            }
            else
                throw new Exception("Need to put the number of fights");
            int length = scanner.nextInt();
            scanner.nextLine();
            String[] strings = new String[n];

            for(int i=0;i < n;i++)
                strings[i] = scanner.nextLine();
            char s1;
            char s2;
            for(String str: strings)
            {
                String winners = String.join("", strings);
                while (winners.length() / 2 >= 2) {
                    StringBuilder nextRound = new StringBuilder();

                    for (int i = 0; i < winners.length() / 2; i++) {
                        s1 = winners.charAt(i * 2);
                        s2 = winners.charAt(i * 2 + 1);

                        // Determine winner for this pair
                        if (s1 == 'R') {
                            if (s2 == 'P')
                                nextRound.append('P'); // 'P' wins
                            else
                                nextRound.append('R'); // 'R' wins
                        } else if (s1 == 'P') {
                            if (s2 == 'S')
                                nextRound.append('S'); // 'S' wins
                            else
                                nextRound.append('P'); // 'P' wins
                        } else {
                            if (s2 == 'R')
                                nextRound.append('R'); // 'R' wins
                            else
                                nextRound.append('S'); // 'S' wins
                        }
                    }

                    winners = nextRound.toString();
                }
            }
            writer.close();

        }catch(Exception e)
        {
            throw new RuntimeException("The input file is incorrect");
        }

    }
}