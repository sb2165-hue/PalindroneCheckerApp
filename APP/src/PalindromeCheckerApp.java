import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String str);
}

// Stack Strategy
class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String str) {

        str = str.toLowerCase().replaceAll("\\s+", "");

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String str) {

        str = str.toLowerCase().replaceAll("\\s+", "");

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// Context Class
class PalindromeChecker {

    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String str) {
        return strategy.checkPalindrome(str);
    }
}

// Main Class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Palindrome Algorithm");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeStrategy strategy;

        if (choice == 1)
            strategy = new StackStrategy();
        else
            strategy = new DequeStrategy();

        PalindromeChecker checker = new PalindromeChecker(strategy);

        if (checker.check(input))
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");

        sc.close();
    }
}