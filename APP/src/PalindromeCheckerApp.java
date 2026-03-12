import java.util.Scanner;

public class PalindromeCheckerApp {

    static boolean isPalindrome(String str, int start, int end) {

        // Base condition
        if (start >= end)
            return true;

        // If characters are not equal
        if (str.charAt(start) != str.charAt(end))
            return false;

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        if (isPalindrome(str, 0, str.length() - 1))
            System.out.println("The string is a Palindrome");
        else
            System.out.println("The string is NOT a Palindrome");
    }
}