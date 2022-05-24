public class Fib { // 0, 1, 1, 2, 3, 5, 8, 13, 21
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }
    public static int fib2(int n, int k, int f0, int f1){
        if (n==k){ // f0: fib@k; f1: fib@k+1
            return f0;
        } else {   // k := 0 (index); f0 := 0; f1 := 1
            return fib2(n, k+1, f1, f1+f0);
        }
    }
    public static void main(String[] args){
        System.out.println(fib(10));
        System.out.println(fib2(4,0,0,1));
    }
}
