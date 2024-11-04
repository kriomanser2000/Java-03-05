import java.io.*;
import java.util.Scanner;

public class FileReaderExample4
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path to file: ");
        String filePath = scanner.nextLine();
        System.out.print("Enter word to search: ");
        String searchWord = scanner.nextLine();
        System.out.print("Enter word for change: ");
        String replacementWord = scanner.nextLine();
        int replacementCount = 0;
        try
        {
            File file = new File(filePath);
            if (!file.exists())
            {
                System.out.println("File not found!");
                return;
            }
            File tempFile = new File("tempFile.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String modifiedLine = line.replaceAll("\\b" + searchWord + "\\b", replacementWord);
                int count = line.split("\\b" + searchWord + "\\b", -1).length - 1;
                replacementCount += count;
                writer.write(modifiedLine);
                writer.newLine();
            }
            reader.close();
            writer.close();
            if (file.delete())
            {
                tempFile.renameTo(file);
            }
            else
            {
                System.out.println("Could not replace the original file.");
            }
            System.out.println("Change count: " + replacementCount);
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
