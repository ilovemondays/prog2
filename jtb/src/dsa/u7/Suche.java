package dsa.u7;

import java.util.Arrays;

/**
 * Created by 2d6-znu-u1 on 10.04.17.
 */
public class Suche {


    public static void main(String[] args) {

        int[] ar = genArray(100);

        long t = System.currentTimeMillis();
        int[] ar2 = sortByInsert(ar);
        System.out.println((System.currentTimeMillis()-t)+"ms");

        System.out.println(getPos(ar, 42, 0, ar.length-1));

    }

    public static int[] genArray(int n) {
        int[] ar = new int[n];
        for(int i=0; i<n; i++) {
            ar[i] = (int) (Math.random()*100);
        }

        return ar;
    }

    public static int[] sortByInsert(int[] ar) {

        // printArray(ar);

        for(int i=1; i<ar.length; i++) {

            if(ar[i] < ar[i-1]) {

                boolean swapping = false;
                int temp;

                for(int k=0; k<i; k++) {


                    if(ar[k] > ar[i] && !swapping) {
                        temp = ar[k];
                        ar[k] = ar[i];
                        ar[i] = temp;
                        swapping = true;
                    } else if( swapping ) {
                        temp = ar[k];
                        ar[k] = ar[i];
                        ar[i] = temp;
                    }

                }

            }

        }

        return ar;

        // printArray(ar);

    }

    public static void printArray(int[] ar) {
        for(int i=0; i<ar.length; i++) {
            System.out.print(ar[i]+", ");
        }

        System.out.println();
    }

    public static int getPos(int[] ar, int k, int from, int to) {
        if( ar.length==0 )
            return -1;

        if( ar[from] > k || ar[to] < k )
            return -1;

        int m = (from+to)/2;

        if( ar[m] == k )
            return m;

        if( ar[m] > k )
            return getPos(ar, k, from, m);

        if( ar[m] < k )
            return getPos(ar, k, m+1, to);



        return -1;
    }

}
