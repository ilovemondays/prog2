package dsa.u5;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;

/**
 * Created by 2d6-znu-u1 on 03.04.17.
 */
public class Binom {

    public static void main(String[] args) {
       /* System.out.println(longBinomialStupid(20,4));
        System.out.println(binomialStupidRecursive(60,6));
        System.out.println(binomialLittleBetter(100,11));
*/

       Iterable<Long> list = listOfPrimeNumbers(100);
        for(long n : list) {
            System.out.print(n+" ");
        }

    }

    public static long longBinomialStupid(long n, long k) {
        return fak(n) / (fak(n-k)*fak(k));
    }

    public static long fak(long k) {
        long res = 1;
        for(int i=2; i<=k; i++) {
            res *= i;
        }

        return res;
    }

    public static long binomialStupidRecursive(long n, long k) {
        if(n==k)
            return 1;
        else if(k==1)
            return n;

        return binomialStupidRecursive(n-1, k-1) + binomialStupidRecursive(n-1, k);
    }

    public static long binomialLittleBetter(long n, long k) {

        long oben = 1;
        for(int i=0; i<k; i++) {
            oben *= (n-i);
        }

        return oben/fak(k);

    }

    public static Iterable listOfPrimeNumbers(long m) {
        ArrayList<Long> list = new ArrayList<>();

        for(int i=2; i<=m; i++) {
            if( i%2==0 && i!=2 )
                continue;

            list.add((long) i);
        }

        int index = 0;
        long smallestPrime = list.get(index);

        while( smallestPrime*smallestPrime < m ) {

            for(int i=index+1; i<list.size(); i++) {
                if( list.get(i)%smallestPrime == 0 ) {
                    list.remove(i);
                    i--;
                }
            }

            index++;
            smallestPrime = list.get(index);


        }



        return list;
    }

    public static int calcListSize(long m) {
        return (int) (m/(Math.log(m)-1.08366));
    }

}
