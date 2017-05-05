package dsa.u07;

/**
 * Created by 5m3-9c9-u1 on 10.04.17.
 */
public class Sort {

    public static int[] sortiere(int[] arr) {
        int[] sort = new int[arr.length];
        int[] temp = new int[arr.length];


        for(int i = 0; i <= arr.length-1; i++) {
            int position = 0;
            int steps = 0;
            if(i==0) {
                sort[i] = arr[i];
                continue;
            }
            for (int k = i; k >= 0; k--) {
                if(sort[k-1] < arr[i]) {
                   position = k;
                }
            }
        }

        return sort;
    }

    public static void main(String[] args) {
        int[] arr = {12,45,34,94,32,68,69,47,99,2};
        System.out.println(java.util.Arrays.toString(sortiere(arr)));
    }
}
