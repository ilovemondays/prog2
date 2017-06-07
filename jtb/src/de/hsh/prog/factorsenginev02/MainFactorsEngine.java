package de.hsh.prog.factorsenginev02;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by jannis on 04.06.17.
 */
public class MainFactorsEngine {

    private static Scanner s = new Scanner(System.in);
    private static FactorsEngineImpl eng = new FactorsEngineImpl();

    public static void main(String[] args) {

        automatic8();

    }

    /**
     * expected result:
     * true
     * true
     * true
     * true
     * true_true
     * true_true
     * false_false
     * correct getfactors
     * correct getfactors
     * runningJobs must contain at least the two huge numbers
     * false
     * correct getfactors
     * correct getfactors
     */
    private static void automatic7() {
        print(eng.startJob(117));
        print(eng.startJob(256));
        print(eng.startJob(123456789012L));
        print(eng.startJob(123456789013L));
        print(Thread.getAllStackTraces().keySet().toString().contains("TFE_123456789012") + "_" + Thread.getAllStackTraces().keySet().toString().contains("TFE_123456789013"));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print(Thread.getAllStackTraces().keySet().toString().contains("TFE_123456789012") + "_" + Thread.getAllStackTraces().keySet().toString().contains("TFE_123456789013"));
        print(Thread.getAllStackTraces().keySet().toString().contains("TFE_117") + "_" + Thread.getAllStackTraces().keySet().toString().contains("TFE_256"));
        printArray(eng.getFactors(117));
        printArray(eng.getFactors(256));
        printArray(eng.getRunningJobs());
        eng.shutdown();
        print(Thread.getAllStackTraces().keySet().toString().contains("TFE_"));
        printArray(eng.getFactors(117));
        printArray(eng.getFactors(256));

    }

    /**
     * expected result:
     * true
     * [99999..99]
     * true
     * true
     * []
     * false
     */
    private static void automatic1() {

        print(eng.startJob(999999999999L)+"");
        printArray(eng.getRunningJobs());
        print(Thread.getAllStackTraces().keySet().toString().contains(("TFE_999999999999")));
        print(eng.abortJob(999999999999L)+"");
        printArray(eng.getRunningJobs());
        print(Thread.getAllStackTraces().keySet().toString().contains("TFE_999999999999"));

    }

    /**
     * true
     * false
     * true
     * []
     * false
     */
    private static void automatic4() {
        print(eng.startJob(1234567890123L));
        print(eng.startJob(1234567890123L));
        print(eng.abortJob(1234567890123L));
        printArray(eng.getRunningJobs());
        print(Thread.getAllStackTraces().keySet().toString().contains("TFE_1234567890123"));
    }

    /**
     * true
     * an array with a few numbers
     * true
     * []
     * false
     */
    private static void automatic8() {
        print(eng.startJob(999999999999L));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printArray(eng.getFactorsIntermediateResult(999999999999L));
        print(eng.abortJob(999999999999L));
        printArray(eng.getRunningJobs());
        print(Thread.getAllStackTraces().keySet().toString().contains("TFE_999999999999"));
    }

    private static void manual() {

        printMenu();


        while(true) {

            print("Your choice? ");
            try {
                handleInput(s.nextLine());
            }  catch (Exception e) {
                print("Invalid input");
            }



        }

    }

    private static void handleInput(String s) {

        s = s.toUpperCase();

        if( s.contains("S") ) {
            // start a new thread or get result factors

            long number = Long.parseLong(s.substring(2));

            if( eng.startJob(number) ) {

                print("Job successfully started: "+number);

            } else {

                long[] factors = eng.getFactors(number);

                if( factors != null )
                    printArray(factors);
                else
                    print("Job still running");
            }

        } else if( s.contains("A") ) {
            // abort thread

            long number = Long.parseLong(s.substring(2));

            if( eng.abortJob(number) ) {
                print("Job aborted successfully: "+number);
            } else {
                print("Job abortion failed: "+number);
            }

        } else if( s.equals("L") ) {

            printAllJobs();

        } else if( s.equals("Q") ) {
            exit();
        }

        print("");

    }

    private static void printAllJobs() {

        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        long[] runningJobs = eng.getRunningJobs();


        print("List of all jobs("+threadSet.size()+" _ "+runningJobs.length+")");
        print("--------------------------------------------");


        if( runningJobs.length == 0 ) {
            print("none");

            print(Thread.getAllStackTraces().toString());
            print("");
            return;
        }

        for(int i=0; i<runningJobs.length; i++) {
            print( String.format("%-10s: %f", Long.toString(runningJobs[i]), eng.getProgress(runningJobs[i])) );
        }

        for(Thread t : threadSet)
            print(t.getName()+", ", false);
        print("");

    }

    private static void exit() {
        s.close();
        eng.shutdown();
        print(Thread.getAllStackTraces().toString());
        System.exit(-1);
    }

    private static void printMenu() {

        print(String.format("%-7s Start a new job for <n> or show its result", "S <n>"));
        print(String.format("%-7s Abort a job for <n>", "A <n>"));
        print(String.format("%-7s List all running jobs and progresses", "L"));
        print(String.format("%-7s Quit program and all jobs", "Q"));
        print("");

    }

    private static void print(Object i) {
        print(i+"");
    }

    private static void print(String s) {
        print(s, true);
    }

    private static void print(String s, boolean lineBreak) {
        if(lineBreak)
            System.out.println(s);
        else
            System.out.print(s);
    }

    private static void printArray(long[] l) {
        if(l.length==0) {
            print("[]");
            return;
        } else if(l.length==1) {
            print("["+l[0]+"]");
            return;
        }

        print("["+l[0], false);
        for(int i=1; i<l.length; i++) {
            print(", "+l[i], false);
        }
        print("]");
        print("");
    }
}
