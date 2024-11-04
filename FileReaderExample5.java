import java.io.*;
import java.util.Scanner;

public class FileReaderExample5
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String[] filePaths = new String[4];
        for (int i = 0; i < 4; i++)
        {
            System.out.print("Enter path to file: " + (i + 1) + ": ");
            filePaths[i] = scanner.nextLine();
        }
        int totalBytesTransferred = 0;
        try (FileWriter writer = new FileWriter(filePaths[3]))
        {
            for (int i = 0; i < 3; i++)
            {
                try (FileReader reader = new FileReader(filePaths[i]))
                {
                    int bytesRead;
                    while ((bytesRead = reader.read()) != -1)
                    {
                        writer.write(bytesRead);
                        totalBytesTransferred++;
                    }
                }
                catch (IOException e)
                {
                    System.out.println("Error reading " + filePaths[i] + ": " + e.getMessage());
                }
            }
            System.out.println("The contents of three files are successfully written to the fourth file.");
        }
        catch (IOException e)
        {
            System.out.println("Error writing " + filePaths[3] + ": " + e.getMessage());
        }
        System.out.println("Total number of bytes transferred: " + totalBytesTransferred);
    }
}
