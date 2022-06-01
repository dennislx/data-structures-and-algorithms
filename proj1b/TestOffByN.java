import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.

    @Test
    public void testEqualChars(){
        CharacterComparator obo = new OffByN(5);
        assertTrue(obo.equalChars('a', 'f'));
        assertTrue(obo.equalChars('f', 'a'));
        assertFalse(obo.equalChars('f', 'h'));
    }
    

}
