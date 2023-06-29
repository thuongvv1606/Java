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
public class FormatDate1 {

    public static void main(String[] args) throws ParseException {
        //step1: Enter date with [dd/mm/yyyy] format
        Date dateFormat = inputDateFormat("Please enter date with format [dd/mm/yyyy]: ");
        //step2: Check input date exits
        //checkInputDate(formatOfDate);
        //step3: Determine day of week with input date
        dayOfInputDate("Your day is ", dateFormat);
    }

    private static Date inputDateFormat(String msg) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Date date;
        String formatOfDate;
        // check input
        while (true) {
            System.out.print(msg);
            formatOfDate = sc.nextLine();
            // check formatOfDate  empty
            if (formatOfDate.isEmpty()) {
                System.out.println("Input could not empty.");
                continue;
            }
            //check format of date like regex format dd/mm/yyyy or not
            if (!formatOfDate.matches("\\d{2}[/]\\d{2}[/]\\d{4}")) {
                System.out.println("input must be format date");
                continue;
            }
            try {
                date = dateformat.parse(formatOfDate);
                //check format of date with chekInputDate() return true or false
                if (!checkInputDate(formatOfDate)) {
                    System.out.println("Date not exits.");
                    continue;
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println("Input must be format date");
            }
        }
        return date;
    }

    private static boolean checkInputDate(String formatOfDate) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCurrent = new Date();

        int day = Integer.parseInt(formatOfDate.substring(0, 2));
        int month = Integer.parseInt(formatOfDate.substring(3, 5));
        int year = Integer.parseInt(formatOfDate.substring(6, 10));
        //check day less than 1 or day greater than 31
        if (day < 1 || day > 31) {
            return false;
        }
        //compare month less than 1 or month greater than 12
        if (month < 1 || month > 12) {
            return false;
        }
        //check month = 4 or 6 or 9 or 11
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            //compare day equal 31
            if (day == 31) {
                return false;
            }
        }
        //check year les than zero
        if (year < 0) {
            return false;
        }
        //check year divided by 4 remainder 0
        if (year % 4 == 0) {
            //compare year divided by 100 remainder 0
            if (year % 100 == 0) {
                //compare year divided by 400 remainder 0
                if (year % 400 == 0) {
                    //compare month equal 2 and day greater than 29
                    if (month == 2 && day > 29) {
                        return false;
                    }
                } else {
                    //compare month equal 2 and day large than 28
                    if (month == 2 && day > 28) {
                        return false;
                    }
                }
            } else {
                //compare month equal 2 and day large than 29
                if (month == 2 && day > 29) {
                    return false;
                }
            }
        } else {
            //compare month equal 2 and day large than 28
            if (month == 2 && day > 28) {
                return false;
            }
        }
        Date dateFomat = dateformat.parse(formatOfDate);
        //compare  dateFormat with after of date current
        if (dateFomat.after(dateCurrent)) {
            return false;
        }
        return true;
    }

    private static void dayOfInputDate(String msg, Date date) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("EEEE");
        System.out.println(msg + dateformat.format(date));
    }
}
