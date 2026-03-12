import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Add characters to Queue and Stack
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            queue.add(ch);   // enqueue
            stack.push(ch);  // push
        }

        boolean palindrome = true;

        // Compare Queue and Stack
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                palindrome = false;
                break;
            }
        }

        // Result
        if (palindrome) {
            System.out.println("It is a Palindrome");
        } else {
            System.out.println("It is not a Palindrome");
        }

        sc.close();
    }
}