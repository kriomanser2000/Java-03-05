import java.io.*;
import java.util.*;

public class FileReaderExample6
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path to file: ");
        String filePath = scanner.nextLine();
        System.out.print("Enter the forbidden words separated by commas: ");
        String[] forbiddenWords = scanner.nextLine().split(",");
        Set<String> forbiddenSet = new HashSet<>();
        for (String word : forbiddenWords)
        {
            forbiddenSet.add(word.trim().toLowerCase());
        }
        StringBuilder processedContent = new StringBuilder();
        Map<String, Integer> removedWordCounts = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] words = line.split("\\s+");
                for (String word : words)
                {
                    String cleanedWord = word.toLowerCase().replaceAll("[^a-zA-Zа-яА-Я]", "");
                    if (forbiddenSet.contains(cleanedWord))
                    {
                        removedWordCounts.put(cleanedWord, removedWordCounts.getOrDefault(cleanedWord, 0) + 1);
                    }
                    else
                    {
                        processedContent.append(word).append(" ");
                    }
                }
                processedContent.append("\n");
            }
        }
        catch (IOException e)
        {
            System.out.println("Error reading: " + e.getMessage());
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            writer.write(processedContent.toString());
        }
        catch (IOException e)
        {
            System.out.println("Error writing: " + e.getMessage());
            return;
        }
        System.out.println("Report: ");
        removedWordCounts.forEach((word, count) ->
                System.out.println("Word \"" + word + "\" was cut out " + count + " times")
        );
        scanner.close();
    }
}
