import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } 

    @Test
    public void testIsPalindrome(){
        String w1 = "aka";
        assertTrue(palindrome.isPalindrome(w1));

        String w2 = "akak";
        assertFalse(palindrome.isPalindrome(w2));

        String w3 = "a";
        assertTrue(palindrome.isPalindrome(w3));

        String w4 = "";
        assertTrue(palindrome.isPalindrome(w4));
    }

    @Test
    public void testIsPalindromeOffby1(){
        
        OffByOne obo = new OffByOne();

        String w1 = "akb";
        assertTrue(palindrome.isPalindrome(w1, obo));

        String w2 = "bjkjc";
        assertFalse(palindrome.isPalindrome(w2, obo));

        String w3 = "bkjc";
        assertTrue(palindrome.isPalindrome(w3, obo));

        String w4 = "";
        assertTrue(palindrome.isPalindrome(w4, obo));
    }
}
