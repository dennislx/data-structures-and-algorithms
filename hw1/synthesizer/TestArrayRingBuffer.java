package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testInit() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        assertEquals(10, arb.capacity());
        assertEquals(0, arb.fillCount);
    }

    @Test(expected=RuntimeException.class)
    public void testEnque(){
        ArrayRingBuffer<String> arb = new ArrayRingBuffer<>(2);
        for (String x : new String[] {"a","b","c"}){
            arb.enqueue(x);
        }
    }

    @Test(expected = RuntimeException.class)
    public void testDeque(){
        ArrayRingBuffer<String> arb = new ArrayRingBuffer<>(3);
        String[] input = new String[] {"a","b","c"};
        for (String x : input){ arb.enqueue(x); }
        while(arb.fillCount != 0) {arb.dequeue();}
        System.out.println(arb.peek());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
