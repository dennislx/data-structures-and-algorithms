package hw2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PercolationTest {
    
    @Test
    public void testConnect(){
        Percolation t = new Percolation(4);
        assertFalse(t.percolates());
        t.open(0,3);
        assertTrue(t.isFull(0, 3));
        t.open(1,2);
        assertFalse(t.isFull(1, 2));
        t.open(1,3);
        assertTrue(t.isFull(1, 3));
        assertEquals(t.numberOfOpenSites(), 3);
        t.open(3,1);t.open(2,3); t.open(3,3);
        assertTrue(t.percolates());
        assertFalse(t.isFull(3, 1));  //this should return false
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNull(){
        Percolation t = new Percolation(4);
        t.open(-1,5);
    }

    @Test
    public void testStat(){
        PercolationFactory pf = new PercolationFactory();
        PercolationStats ps = new PercolationStats(20, 10, pf);
        System.out.println(ps.mean());
        System.out.println(ps.stddev());
    }

}
