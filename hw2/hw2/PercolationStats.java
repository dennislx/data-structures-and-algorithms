package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double A = 1.96;
    StdRandom rdm;
    StdStats sts;
    private double[] res;
    private int N, T;

    public PercolationStats(int N, int T, PercolationFactory pf)   // perform T independent experiments on an N-by-N grid
    {
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException("Number of trials and rows should be greater than zero");
        this.N = N; 
        this.T = T;
        res = new double[T];
        run(pf);
    }
    private void run(PercolationFactory pf)
    {
        for (int i=0; i<T; i++){
            Percolation p = pf.make(N);
            while (! p.percolates()){
                int row = rdm.uniform(0, N);
                int col = rdm.uniform(0, N);
                p.open(row, col);
            }
            res[i] = (float)p.numberOfOpenSites()/(N*N);
        }
    }
    public double mean()                                           // sample mean of percolation threshold
    {
        return sts.mean(res);
    }
    public double stddev()                                         // sample standard deviation of percolation threshold
    {
        return sts.stddev(res);
    }
    public double confidenceLow()                                  // low endpoint of 95% confidence interval
    {
        return mean() - A * stddev() / Math.sqrt(T);
    }
    public double confidenceHigh()                                 // high endpoint of 95% confidence interval
    {
        return mean() + A * stddev() / Math.sqrt(T);
    }

    private static void main(String[] args) {
        PercolationFactory s = new PercolationFactory();
        PercolationStats ps = new PercolationStats(20, 300, s);
        System.out.print(String.format(
            "mean: %.4f \nstd: %.4f \nci: [%.4f, %.4f]", ps.mean(), ps.stddev(), ps.confidenceLow(), ps.confidenceHigh())
        );
    }
}

