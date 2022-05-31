import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FlikTest {
    @Test
    public void testFilk_both0(){
        boolean thesame = Flik.isSameNumber(0, 0);
        assertTrue("start is fine", thesame);
    }

    @Test
    public void testFilk_both127(){
        boolean thesame = Flik.isSameNumber(127, 127);
        assertTrue("127 should print 127", thesame);
    }

    @Test
    public void testFilk_wrong128(){
        boolean notthesame = Flik.isSameNumber(128, 128);
        assertFalse("128 isn't equal to 128", notthesame);
    }

    @Test
    public void testFilk_wherewrong(){
        for (int i=0, j=0; i<128; ++i, ++j){
            boolean thesame = Flik.isSameNumber(i, j);
            assertTrue(String.format("%d should be the same as %d", i, j), thesame);
        }
    }

}
