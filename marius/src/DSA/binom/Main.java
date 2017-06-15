package DSA.binom;

/**
 * Created by krz-nqy-u1 on 03.04.17.
 */
public class Main {
    public static void main(String[] args){
    System.out.println(longBinomialStupid(20, 4));
    }

    public static long longBinomialStupid(long n, long k){
        return getFakultaet(n)/(getFakultaet(n-k)*getFakultaet(k));
    }

    private static long getFakultaet(long n) {

        long nfakultaet = 1;
        for (long j=n; j>=1; j--) {
            nfakultaet = j*nfakultaet;

        }
        return nfakultaet;
    }
   // public static long BinomialLittleBetterALong(long n, long k) {


  //  }
}


