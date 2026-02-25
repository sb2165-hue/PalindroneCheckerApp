public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {

        // Convert string to character array
        char[] chars = input.toCharArray();

        // Initialize two pointers
        int left = 0;
        int right = chars.length - 1;

        // Compare characters from both ends
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false; // Mismatch found
            }
            left++;
            right--;
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {
        String str = "madam";

        if (isPalindrome(str)) {
            System.out.println(str + " is a Palindrome.");
        } else {
            System.out.println(str + " is NOT a Palindrome.");
        }
    }
}
