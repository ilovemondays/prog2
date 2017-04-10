package dsa.u7;

import java.util.Arrays;

/**
 * Created by 2d6-znu-u1 on 10.04.17.
 */
public class Suche {


    public static void main(String[] args) {

        long t = System.currentTimeMillis();
        sortByInsert(genArray(100));
        System.out.println((System.currentTimeMillis()-t)+"ms");

    }

    public static int[] genArray(int n) {
        int[] ar = new int[n];
        for(int i=0; i<n; i++) {
            ar[i] = (int) (Math.random()*100);
        }

        return ar;
    }

    public static void sortByInsert(int[] ar) {

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

        // printArray(ar);

    }

    public static void printArray(int[] ar) {
        for(int i=0; i<ar.length; i++) {
            System.out.print(ar[i]+", ");
        }

        System.out.println();
    }

}
