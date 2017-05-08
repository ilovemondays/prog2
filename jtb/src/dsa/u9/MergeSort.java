package dsa.u9;

import dsa.u7.Suche;

import java.util.Arrays;

/**
 * Created by 2d6-znu-u1 on 08.05.17.
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] ar = new int[20000];
        int[] ar2 = new int[ar.length];

        for(int i=0; i<ar.length; i++) {
            ar[i] = (int) (Math.random()*1000);
            ar2[i] = ar[i];
        }

        long start = System.currentTimeMillis();

        ar = mergeSort(ar, 0, ar.length-1);

        System.out.println("Time 01: "+ (System.currentTimeMillis()-start) +" ms");
        System.out.println(Arrays.toString(ar));


        boolean b = true;

        for(int i=1; i<ar.length; i++) {
            if( ar[i-1] > ar[i] ) {
                b = false;
                break;
            }
        }

        System.out.println( "is Sorted = " + b );



        start = System.currentTimeMillis();

        ar = Suche.sortByInsert(ar2);

        System.out.println("Time 02: "+ (System.currentTimeMillis()-start) +" ms");
        System.out.println(Arrays.toString(ar));

        b = true;

        for(int i=1; i<ar2.length; i++) {
            if( ar2[i-1] > ar2[i] ) {
                b = false;
                break;
            }
        }

        System.out.println( "is Sorted = " + b );



    }

    public static int[] mergeSort(int[] array, int low, int high) {

        if( low >= high )
            return array;

        int mid = (low+high)/2;

        array = mergeSort(array, low, mid);
        array = mergeSort(array, mid+1, high);

        return merge(array, low, mid, high);
    }

    public static int[] merge(int[] array, int low, int mid, int high) {

        int i=0;
        int j=low;

        int[] b = new int[mid+1];

        while(j<=mid) {

            b[i] = array[j];
            i++;
            j++;

        }

        i = 0;
        int k = low;

        while( k<j && j<=high ) {

            if( b[i] <= array[j] ) {
                array[k] = b[i];
                i++;
            } else {
                array[k] = array[j];
                j++;
            }

            k++;

        }

        while( k<j ) {
            array[k] = b[i];
            i++;
            k++;
        }

        return array;

    }
}
