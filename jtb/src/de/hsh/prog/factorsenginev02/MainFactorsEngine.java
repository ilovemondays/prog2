package de.hsh.prog.factorsenginev02;

import pseudoanonymPackage.u22.S;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * Created by jannis on 04.06.17.
 */
public class MainFactorsEngine {

    public static void main(String[] args) {

        boolean quit = false;
        FactorsEngineImp1 eng = new FactorsEngineImp1();

        Scanner s = new Scanner(System.in);
        printMenu();


        while( quit == false ) {

            print("Your choice? ", true);

            String input = s.nextLine();

            if( input.toUpperCase().equals("Q") )
                break;
            else if( input.toUpperCase().contains("S") ) {

                long number = Long.parseLong(input.substring(2));

                if( eng.startJob( Long.parseLong(input.substring(2), 10) ) ) {

                    System.out.println("Starting " + number);

                } else {

                    printArray(eng.getFactors(number));

                }

            } else if( input.toUpperCase().equals("L") ) {

                long[] jobs = eng.getRunningJobs();

                for(int i=0; i<jobs.length; i++) {
                    print(String.format( "%20s: %f", jobs[i], eng.getProgress(jobs[i])), true );
                }

            }
            else
                print(String.format("invalid input %n"), true);

        }

        s.close();



    }

    private static void printMenu() {

        print(String.format("%-7s Start a new job for <n> or show its result", "S <n>"), true);
        print(String.format("%-7s Abort a job for <n>", "A <n>"), true);
        print(String.format("%-7s List all running jobs and progresses", "L"), true);
        print(String.format("%-7s Quit program and all jobs", "Q"), true);
        print("", true);

    }

    private static void print(String s, boolean lineBreak) {
        if(lineBreak)
            System.out.println(s);
        else
            System.out.print(s);
    }

    private static void printArray(long[] l) {

        System.out.print("[");
        for(int i=0; i<l.length; i++) {
            System.out.print(l[i]+",");
        }
        System.out.println("]");

    }
}
