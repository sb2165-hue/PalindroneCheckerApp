import java.util.*;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeCheckerApp {

    // Function to check palindrome
    public static boolean isPalindrome(Node head) {

        ArrayList<Character> list = new ArrayList<>();

        Node temp = head;

        // Traverse linked list and store characters
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        int start = 0;
        int end = list.size() - 1;

        // Compare characters
        while (start < end) {
            if (list.get(start) != list.get(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        Node head = null;
        Node tail = null;

        // Convert string to linked list
        for (int i = 0; i < str.length(); i++) {
            Node newNode = new Node(str.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Check palindrome
        if (isPalindrome(head)) {
            System.out.println("It is a Palindrome");
        } else {
            System.out.println("It is not a Palindrome");
        }

        sc.close();
    }
}