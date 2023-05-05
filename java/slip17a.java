import java.util.Scanner;
public class slip17a
{
    public static void main(String[] args) throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();    
        for (int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            if (isVowel(c))
            {
                Thread.sleep(3000); //sleep for 3 seconds
                System.out.println(c);
            }
        }
        scanner.close();
    }
    public static boolean isVowel(char c)
    {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
