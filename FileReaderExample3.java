import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderExample3
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path to file: ");
        String filePath = scanner.nextLine();
        int letterCount = 0;
        int digitCount = 0;
        int punctuationCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            int character;
            while ((character = reader.read()) != -1)
            {
                if (Character.isLetter(character))
                {
                    letterCount++;
                }
                else if (Character.isDigit(character))
                {
                    digitCount++;
                }
                else if (isPunctuation(character))
                {
                    punctuationCount++;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Error reading: " + e.getMessage());
        }
        System.out.println("Word count: " + letterCount);
        System.out.println("Nums count: " + digitCount);
        System.out.println("Num of punctuation marks: " + punctuationCount);
    }
    private static boolean isPunctuation(int character)
    {
        return character == '.' || character == ',' || character == ';' || character == ':' ||
                character == '!' || character == '?' || character == '-' || character == '"' ||
                character == '\'' || character == '(' || character == ')' || character == '[' ||
                character == ']' || character == '{' || character == '}' || character == '/';
    }
}
