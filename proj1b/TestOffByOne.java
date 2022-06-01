import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars(){
        OffByOne obo = new OffByOne();
        assertTrue(obo.equalChars('a', 'b'));
        assertTrue(obo.equalChars('b', 'a'));
        assertFalse(obo.equalChars('a', 'a'));
        assertFalse(obo.equalChars('c', 'a'));
        assertFalse(obo.equalChars('a','B'));
        assertFalse(obo.equalChars('&','$'));
        assertTrue(obo.equalChars('&','\''));
    }

}
