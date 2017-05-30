package mathe2;

/**
 * Created by jannis on 30.05.17.
 */
public class LGSIteration {

    public static void main(String[] args) {

        double[][] a = new double[][] {
            {2, 2, 3},
            {2, 6, 2},
            {2, 3, 8}
        };
        double[] b = new double[] {6, -2, 4};
        printVektor(jacobi(a, b, 3));

    }

    public static double[] jacobi(double[][] a, double[] b, int step) {
        double[] x = new double[a.length];


        // startvektor
        for(int i=0; i<x.length; i++)
            x[i] = 0;

        double[] y = update(b, a, x);
        step--;

        while( step > 0 ) {
            x = y;
            y = update(b, a, x);
            step--;
        }


        return y;

    }

    private static double[] update(double[] b, double[][] a, double[] x) {
        double[] y = new double[x.length];

        for(int i=0; i<a.length; i++) {
            y[i] = b[i];

            for(int k=0; k<a.length; k++) {

                if(k!=i) {
                    y[i] -= x[k] * a[i][k];
                }

            }

            if( Math.abs(a[i][i]) <= 1E-8D )
                return null;

            y[i] /= a[i][i];

        }

        return y;
    }

    public static void printMatrix(double[][] m) {
        for(int i=0; i<m.length; i++) {
            for(int k=0; k<m.length; k++) {
                System.out.print(m[i][k]+" ");
            }
            System.out.println();
        }
    }

    public static void printVektor(double[] m) {
        for(int i=0; i<m.length; i++) {
            System.out.print(m[i]+" ");
        }
        System.out.println();
    }

}
