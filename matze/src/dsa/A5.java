package dsa;

import java.util.ArrayList;

/**
 * Created by 5m3-9c9-u1 on 03.04.17.
 */
public class A5 {
    public static long getFak(long n) {
        long gesamt = 1;
        for (int i = 1; i <= n; i++) {
            gesamt = i*gesamt;
        }
        return (long) gesamt;
    }

    public static long binomialStupid(long n, long k) {
        return getFak(n) / (getFak(n-k) * getFak(k));
    }

    static long binomialStupidRecursive(long n, long k) {
        if(k == 1) {
            return n;
        } else if (k==n) {
            return 1;
        }
        return binomialStupidRecursive(n - 1, k -1) + binomialStupidRecursive(n - 1, k);
    }

    public static long binomialLittleBetter(long n, long k) {
        long temp1 = n-(k-1);

        for (long i = n-(k-2); i <= n; i++) {
            temp1= temp1*i;
        }

        return temp1 / getFak(k);
    }

    public long[] listOfPrimeNumbers(long m) {
        long length = m/2;
        long[] list = new ArrayList<long>();
    }

    public static void main(String[] args) {
        System.out.println(binomialStupid(20, 9));
        System.out.println(binomialStupidRecursive(20, 9));
        System.out.println(binomialLittleBetter(50, 5));
    }
}
