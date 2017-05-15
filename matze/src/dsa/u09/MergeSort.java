package dsa.u09;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by 5m3-9c9-u1 on 08.05.17.
 */
public class MergeSort {
    public static int counter = 0;

    public static void main(String[] args) {
        long start;
        int[] a = randomArray(500000);

        int[] a3 = a;
        start = System.currentTimeMillis();
        Arrays.sort(a3);
        //System.out.println(Arrays.toString(a3));
        System.out.println("Arrays.sort(): " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        int[] a2 = a;
        a2 = mergeSort(a2, 0, a2.length-1);
        //System.out.println(Arrays.toString(a2));
        System.out.println("MergeSort: " + (System.currentTimeMillis() - start));
    }

    public static int[] randomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = (int)(Math.random() * 1000)+1;
        }
        return arr;
    }

/* AUS DEM SKRIPT
    Algorithm MergeSort(L,lo,hi)
     if(lo>=hi) return L;
        mid←(lo+hi)/2;
        L←MergeSort(L,lo,mid);
        L←MergeSort(L,mid+1,hi);
     return Merge(lo,mid,hi);

     Algorithm Merge(A,lo,mid,hi)
         i←1; j←lo;
         while j<=mid do
            B[i]=A[j];
            i←i+1; j←j+1;
         i←1; k←lo;
         while k<j and j<=hi do
            if(B[i]<=A[j])
            A[k]←B[i]; i←i+1;
         else
            A[k]←A[j]; j←j+1;
            k←k+1;
         while k<j do
            A[k]←B[i]; i←i+1; k←k+1;
         return A;
 */

    public static int[] mergeSort(int[] list, int lo, int hi) {
        if(lo>=hi) return list;
        int mid = (lo+hi)/2;
        list = mergeSort(list, lo, mid);
        list = mergeSort(list,mid+1, hi);

        return merge(list, lo, mid, hi);
    }

    public static int[] merge(int[] a, int lo, int mid, int hi) {
        int i = 0; // zähler für 0 bis xy
        int j = lo; // zähler für bereich in a, der nicht kopiert wurde
        int k = lo; // zähler für den lo to hi

        int[] b = new int[mid+1]; // hilfsarray

        // kopiere erste hälfte aus a ins hilfsarray
        while (j<=mid) {
            b[i] = a[j];
            j++;
            i++;
        }

        i = 0;
        // k=lo und j=mid
        while (k<j && j<=hi) {
            //System.out.println(++counter + "b:"+b[i]+" a:"+a[j]);
            //System.out.println("hilfstring="+ Arrays.toString(b) +" // a="+Arrays.toString(a));
            if(b[i] <= a[j]) {
                a[k] = b[i];
                i++;
            } else {
                a[k] = a[j];
                j++;
            }
            k++;
        }

        // wenn noch etwas im hilfsarray übrig ist:
        while (k<j) {
            a[k] = b[i];
            k++;
            i++;
        }

        return a;
    }
}
