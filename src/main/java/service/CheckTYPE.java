package service;

import java.util.Scanner;

public class CheckTYPE {
    public static int CheckType(Scanner args) throws Exception {

        String input;
        int ch1 = 0;
        float ch2;
        String ch3;

        Scanner one = new Scanner(System.in);

        input = one.nextLine();

        try {
            ch1 = Integer.parseInt(input);
            return ch1;
        } catch (NumberFormatException e) {


        }

        try {
            ch2 = Float.parseFloat(input);
            System.out.println("You must enter a number");
            return ch1;
        } catch (NumberFormatException e) {

        }
        try {
            ch3 = String.valueOf(input);
            System.out.println("You must enter a number");
        } catch (NumberFormatException e) {

        }


        return ch1;
    }

}




