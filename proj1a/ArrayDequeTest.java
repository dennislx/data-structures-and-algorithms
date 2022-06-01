import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ArrayDequeTest {
    
    @Test
    public void testNegativeSize(){
        ArrayDeque L = new ArrayDeque<>();
        assertNull(L.removeLast());
        assertNull(L.get(0));
        L.addFirst(0); L.addLast(1); L.removeLast();
        assertEquals(L.getLast(), 0);  //capacity is 2
    }

    @Test
    public void testAddLast(){
        Integer[] integer = new Integer[]{1,2,3,4,5,6,7,8};
        ArrayDeque L1 = new ArrayDeque<Integer>(integer);
        L1.addLast(9);
        assertEquals(L1.getLast(), 8);
        L1.addFirst(0);
        assertEquals(L1.getFirst(), 15);
        Integer[] another = new Integer[]{1,2,3,4,5,6,7,8};
        ArrayDeque L2 = new ArrayDeque<Integer>(another);
        L2.addFirst(0);
        assertEquals(L2.getFirst(), 15);
        L2.size();
    }

    @Test
    public void testRemove(){
        Integer[] integer = new Integer[]{1,2,3,4,5,6,7};
        ArrayDeque L = new ArrayDeque<Integer>(integer);
        assertEquals(L.removeFirst(), 1);
        assertEquals(L.getFirst(), 1);
        L.removeLast(); L.addFirst(1); L.addFirst(0); 
        L.printDeque();  // 1 2 3 4 5(last) 6 0(first) X 
        assertEquals(L.getFirst(), 7);
        for (int i=L.getLast(), n=0; n<L.size(); n++,i--){
            assertEquals(L.removeLast(), 6-n);
            assertEquals(L.getLast(), (i-1+8)%8);
        }
        ArrayDeque L2 = new ArrayDeque<>();
        for (int i=0; i<=5; i++) L2.addFirst(i);
        assertEquals(L2.removeFirst(), 5);
    }

    @Test
    public void testGet(){
        ArrayDeque L = new ArrayDeque<>();
        L.addLast(0); L.removeFirst();
        L.addLast(2); L.removeFirst();
        L.addFirst(4);L.addLast(5); L.removeLast(); L.removeFirst();
        L.addFirst(8); 
        L.addFirst(9); 
        L.removeLast(); 
        assertEquals(L.getLast(), 1);
        L.removeLast();

        ArrayDeque L2 = new ArrayDeque<>();
        L2.addLast(0); L2.removeFirst(); L2.addLast(2);
        L2.addLast(4); L2.removeFirst(); L2.addLast(6);
        L2.removeFirst(); L2.addLast(8);
        L2.removeFirst(); // first = 1, last = 0, arr = [6(last) , 8(first)]
        assertEquals(L2.getFirst(), 0);
        L2.removeFirst();
    }

    @Test
    public void testAddAndRemove(){
        ArrayDeque L3 = new ArrayDeque<>();
        for (int i=0; i<=2; i++) L3.addLast(i);
        assertEquals(L3.removeLast(), 2);
        assertEquals(L3.removeFirst(), 0);
        assertEquals(L3.removeLast(), 1);
    }

    @Test
    public void testBasic(){
        ArrayDeque L = new ArrayDeque<>();
        for (int i=0; i< 12; i++){
            L.addLast(i);
            assertEquals(L.get(i), i);
        }
    }

    @Test
    public void testAddNTimes(){
        ArrayDeque L = new ArrayDeque<>();
        for (int i=0; i<12; i++){
            L.addFirst(i);
        }
        L.removeFirst(); L.removeLast();
        assertFalse(L.isEmpty());
    }

    @Test    
    public void testAddSize(){
        ArrayDeque L = new ArrayDeque<>();
        L.addLast(0); L.addFirst(1);
        assertEquals(L.size(), 2);
        L.addLast(3);
        assertEquals(L.size(), 3);
        L.addLast(5); L.addLast(6); L.addLast(7);
        assertEquals(L.size(), 6);
    }
    

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
        * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        ArrayDeque<String> ad1 = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, ad1.isEmpty());

        ad1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, ad1.size()) && passed;
        passed = checkEmpty(false, ad1.isEmpty()) && passed;

        ad1.addLast("middle");
        passed = checkSize(2, ad1.size()) && passed;

        ad1.addLast("back");
        passed = checkSize(3, ad1.size()) && passed;

        System.out.println("Printing out deque: ");
        ad1.printDeque();

        printTestStatus(passed);
    }

    /** Adds an item, then removes an item, and ensures that ad is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, ad1.isEmpty());

        ad1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, ad1.isEmpty()) && passed;

        ad1.removeFirst();
        // should be empty
        passed = checkEmpty(true, ad1.isEmpty()) && passed;

        printTestStatus(passed);

    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }
}
