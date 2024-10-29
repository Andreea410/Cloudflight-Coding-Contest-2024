import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class LEVEL1 {
    public static void main(String[] args) {
        String inputFilePath = "E:\\EXTRAS FOR CV\\CCC\\TRAINING\\ROCK-PAPER-SCISSORS\\level1\\level1_5.in";
        String outputFilePath = "E:\\EXTRAS FOR CV\\CCC\\TRAINING\\ROCK-PAPER-SCISSORS\\level1\\outputlevel1_5.txt";

        try {
            Scanner scanner = new Scanner(new File(inputFilePath));
            PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath));
            int n;
            if(scanner.hasNextInt()) {
                n = scanner.nextInt();
            }
            else
                throw new Exception("Need to put the number of fights");
            scanner.nextLine();
            String[] strings = new String[n];

            for(int i=0;i < n;i++)
                strings[i] = scanner.nextLine();
            char s1;
            char s2;

            for(String str: strings)
            {
                s1 = str.charAt(0);
                s2 = str.charAt(1);
                if(s1 == 'R')
                {
                    if(s2 == 'P')
                        writer.print("P");
                    else
                        writer.print("R");
                }
                else if(s1 =='P')
                {
                    if(s2 == 'S')
                        writer.print("S");
                    else
                        writer.print("P");
                }
                else {
                    if(s2 == 'R')
                        writer.print("R");
                    else
                        writer.print("S");
                }
                writer.println();
            }
            writer.close();

        }catch(Exception e)
        {
            throw new RuntimeException("The input file is incorrect");
        }

    }
}