package DSA.A09;

import java.util.Random;
import java.util.Arrays;

/**
 * Created by krz-nqy-u1 on 08.05.17.
 */
public class Main {
    static int n = 50;
    public static void main(String[] args){
        int[] array = new int[n];
        for (int i=0; i <= array.length-1;i++ ) {
            array[i] = (int) Math.random()*1000;
        }
        System.out.println(Arrays.toString(array));
        MergeSort.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}

