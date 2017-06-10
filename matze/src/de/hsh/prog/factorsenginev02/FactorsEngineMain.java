package de.hsh.prog.factorsenginev02;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by matthiasdietrich on 10.06.17.
 */
public class FactorsEngineMain {
    public static void main(String[] args) {
        FactorsEngineImpl FE = new FactorsEngineImpl();
        Scanner scan = new Scanner(System.in);
        String userInput;
        long number;

        System.out.println("Options");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Q      Quit program");
        System.out.println("S <n>  Start new job to compute factors of <n> starten");
        System.out.println("or show computed result");
        System.out.println("A <n>  Abort the compute job for <n>");
        System.out.println("L      List running jobs and progresses");
        System.out.println();

        while (!((userInput = scan.nextLine()).equalsIgnoreCase("q"))) {
            // Start New Jobs
            if(testUserInput(userInput,"s")) {
                try {
                    number = Long.parseLong(userInput.substring(1).trim());
                    FE.startJob(number);
                } catch(Exception e) {
                    System.out.println("Parameter not compatible. Please try again.");
                }

            }

            // Get Process List
            if(testUserInput(userInput,"l")) {
                FE.listJobs();
            }

            // Abort Job
            if(testUserInput(userInput,"a")) {
                try {
                    number = Long.parseLong(userInput.substring(1).trim());
                    FE.abortJob(number);
                } catch(Exception e) {
                    System.out.println("Parameter not compatible. Please try again.");
                }

            }
        }

        System.out.println("QUIT");
        System.exit(-1);


    }

    /**
     * Check if first char in string is matching. Ignores case
     * @param userInput
     * @param compareTo
     * @return
     */
    private static boolean testUserInput(String userInput, String compareTo) {
        return (userInput.substring(0,1).equalsIgnoreCase(compareTo));
    }
}
