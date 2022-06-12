package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int top, buttom, nopen, N;
    private boolean[] sites; //flag to show whether some site is open
    /*
     * parent/size/count
     * find/count/connected/union
     */
    private WeightedQuickUnionUF uf;    //used to decide percolate
    private WeightedQuickUnionUF uff;   //used to decide full

    public Percolation(int N)                // create N-by-N grid, with all sites initially blocked
    {
        if (N <= 0) 
            throw new IllegalArgumentException("Input row and column size should be greater than zero");
        sites = new boolean[N*N];
        uf = new WeightedQuickUnionUF(N*N+2);
        uff= new WeightedQuickUnionUF(N*N+1);
        top = N*N; buttom = N*N+1;
        nopen = 0; this.N = N;
        for (int i=0; i < N; i++){
            uf.union(top, i);
            uf.union(buttom, N*N-i-1);
            uff.union(top,i);
        }
    }
    private int xyToN(int row, int col)
    {
        validate(row, col);
        return row*N + col;
    }
    public void open(int row, int col)       // open the site (row, col) if it is not open already
    {
        if (isOpen(row, col))
            return;
        int n = xyToN(row, col);
        sites[n] = true;
        nopen += 1;
        /*
         * create a new set if no neighbor to union
         * otherwise union neighbors
         */
        for (int[] xy : new int[][]{{-1,0},{1,0},{0,-1},{0,1}}){
            xy[0] += row; xy[1] += col;
            if (validate(xy[0],xy[1], false) && isOpen(xy[0], xy[1])) {
                int nc = xyToN(xy[0], xy[1]);
                uf.union(nc, n);
                uff.union(nc, n);
            }
        }       
    }
    public boolean isOpen(int row, int col)  // is the site (row, col) open?
    {
        int n = xyToN(row, col);
        return sites[n];
    }
    public boolean isFull(int row, int col)  // is the site (row, col) full?
    {
        int n = xyToN(row, col);
        return isOpen(row, col) && uff.connected(n, top);
    }
    public int numberOfOpenSites()           // number of open sites
    {
        return nopen;
    }
    public boolean percolates()              // does the system percolate?
    {
        return uf.connected(top, buttom);
    }
    private boolean validate(int x, int y){
        return validate(x, y, true);
    }

    private boolean validate(int x, int y, boolean exit){
        if (x < 0 || x >= N || y < 0 || y >= N) 
            if (exit)
                throw new IndexOutOfBoundsException("Input out of bounds");
            else
                return false;
        return true;
    }
    public static void main(String[] args)   // use for unit testing (not required)
    {
        Percolation t = new Percolation(3);
        t.open(1,2);
    }
}
