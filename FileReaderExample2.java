import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderExample2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path to file: ");
        String filePath = scanner.nextLine();
        System.out.print("Enter word for search: ");
        String wordToFind = scanner.nextLine();
        int wordCount = countWordOccurrences(filePath, wordToFind);
        if (wordCount == -1)
        {
            System.out.println("Error reading.");
        }
        else
        {
            System.out.println("Word \"" + wordToFind + "\" is found in the file " + wordCount + " time(s).");
        }
        scanner.close();
    }
    public static int countWordOccurrences(String filePath, String wordToFind)
    {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] words = line.split("\\W+");
                for (String word : words)
                {
                    if (word.equalsIgnoreCase(wordToFind))
                    {
                        count++;
                    }
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return -1;
        }
        return count;
    }
}
