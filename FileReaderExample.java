import java.io.*;
import java.util.Scanner;

public class FileReaderExample
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path to file: ");
        String filePath = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            int linesPerPage = 10;
            int lineCount = 0;
            System.out.println("\nFile content:\n");
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
                lineCount++;
                if (lineCount % linesPerPage == 0)
                {
                    System.out.print("\nPress Enter to continue...");
                    scanner.nextLine();
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + filePath);
        }
        catch (IOException e)
        {
            System.out.println("Error reading: " + e.getMessage());
        }
    }
}
