import java.util.*;

public class PalindromeCheckerApp {

    // Two Pointer Method
    public static boolean twoPointerPalindrome(String str) {

        str = str.toLowerCase().replaceAll("\\s+", "");

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    // Stack Method
    public static boolean stackPalindrome(String str) {

        str = str.toLowerCase().replaceAll("\\s+", "");

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Two Pointer Performance
        long start1 = System.nanoTime();
        boolean result1 = twoPointerPalindrome(input);
        long end1 = System.nanoTime();

        // Stack Performance
        long start2 = System.nanoTime();
        boolean result2 = stackPalindrome(input);
        long end2 = System.nanoTime();

        long time1 = end1 - start1;
        long time2 = end2 - start2;

        System.out.println("\nResults:");
        System.out.println("Two Pointer Method: " + result1 + " | Time: " + time1 + " ns");
        System.out.println("Stack Method: " + result2 + " | Time: " + time2 + " ns");

        sc.close();
    }
}