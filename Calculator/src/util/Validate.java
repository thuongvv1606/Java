package util;

import java.util.Scanner;

public class Validate {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Don't let anyone instantiate this class.
     */
    private Validate() {
    }

    /**
     * Returns the valid integer value scanned from the input.
     *
     * @param messageInfo the message to be printed instructing the user to
     * input
     * @param messageErrorOutOfRange the message will be printed if the String
     * parse value is out of range
     * @param messageErrorInvalidNumber the message will be printed if the
     * String does not contain a parsable integer
     * @param min minimum limit value
     * @param max maximum limit value
     * @return the valid integer value scanned from the input
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max
    ) {
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }

}
