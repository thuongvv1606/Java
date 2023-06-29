/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatdate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class FormatDate {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {

        //step1: Enter date with [dd/mm/yyyy] format
        Date dateFormat = inputDateFormat("Please enter date with format [dd/mm/yyyy]: ");
        //step2: Check input date exits
        checkInputDateExits(dateFormat);
        //step3: Determine day of week with input date
        dayOfInputDate("Your day is ", dateFormat);
    }

    private static Date inputDateFormat(String msg) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        String input;
        Date date = null;
        // check input
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            // check input empty
            if (input.isEmpty()) {
                System.out.println("Input could not empty.");
                continue;
            }
            try {
                date = dateformat.parse(input);
                int day = Integer.parseInt(input.substring(0, 2));
                //compare day less than 1 or day greater than 31
                if (day < 1 || day > 31) {
                    System.out.println("Day not exist");
                    continue;
                }
                int month = Integer.parseInt(input.substring(3, 5));
                //compare month less than 1 or month greater than 12
                if (month < 1 || month > 12) {
                    System.out.println("Month not exist");
                    continue;
                }
                // compare month eaqual 4, 6, 9, 11
                if (month == 4 || month == 6 || month == 9 || month == 11) {
                    //compar day equal 31
                    if (day == 31) {
                        System.out.println("Date not exist");
                        continue;
                    }
                }
                int year = Integer.parseInt(input.substring(6, 10));
                //compare year less than 0
                if (year < 0) {
                    System.out.println("Date not exist");
                    continue;
                }
                //compare year divided by 4 remainder 0
                if (year % 4 == 0) {
                    //compare year divided by 100 remainder 0
                    if (year % 100 == 0) {
                        //compare year divided by 400 remainder 0
                        if (year % 400 == 0) {
                            //compare month equal 2 and day greater than 29
                            if (month == 2 && day > 29) {
                                System.out.println("Date not exist");
                                continue;
                            }
                        } else {
                            //compare month equal 2 and day large than 28
                            if (month == 2 && day > 28) {
                                System.out.println("Date not exist");
                                continue;
                            }
                        }
                    } else {
                        //compare month equal 2 and day large than 29
                        if (month == 2 && day > 29) {
                            System.out.println("Date not exist");
                            continue;
                        }
                    }
                } else {
                    //compare month equal 2 and day large than 28
                    if (month == 2 && day > 28) {
                        System.out.println("Date not exist");
                        continue;
                    }
                }

                if ((Date) date != date) {
                    System.out.println("input must be format date");
                } else {
                    break;
                }
                break;
            } catch (ParseException | NumberFormatException e) {
                System.out.println("Input must be format date");
            }
        }
        return date;
    }

    private static boolean checkInputDateExits(Date dateFormat) throws ParseException {
        Date dateCurrent = new Date();
        //compare  dateFormat with after of date current
        if (dateFormat.after(dateCurrent)) {
            System.out.println("Date does not exists");
            return false;
        } else {
            return true;
        }

    }

    private static void dayOfInputDate(String msg, Date date) {
        SimpleDateFormat dateformat = new SimpleDateFormat("EEEE");
        System.out.println(msg + dateformat.format(date));
    }

}
