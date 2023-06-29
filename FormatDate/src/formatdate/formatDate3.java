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
public class formatDate3 {

    public static void main(String[] args) throws ParseException {
        //step1: Enter date with [dd/mm/yyyy] format
        String dateFormat = inputDateFormat("Please enter date with format [dd/mm/yyyy]: ");
        //step2: Check input date exits
        boolean check = checkInputDate(dateFormat);
        if(check == true) {
            inputDateFormat("Please enter date with format [dd/mm/yyyy]: ");
        }
        checkInputDate(dateFormat);
        //step3: Determine day of week with input date
        dayOfInputDate("Your day is ", dateFormat);
    }

    private static String inputDateFormat(String msg) throws ParseException {
        Scanner sc = new Scanner(System.in);
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
            try {
                //check input formatOfDate like regex format dd/dd/dddd
                if (!formatOfDate.matches("\\d{2}[/]\\d{2}[/]\\d{4}")) {
                    System.out.println("input must be format date");
                } else {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Input must be format date");
            }
        }
        return formatOfDate;
    }

    private static boolean checkInputDate(String formatOfDate) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCurrent = new Date();
        int day = Integer.parseInt(formatOfDate.substring(0, 2));
        int month = Integer.parseInt(formatOfDate.substring(3, 5));
        int year = Integer.parseInt(formatOfDate.substring(6, 10));
        while (true) {
            Date date = null;
            date = dateformat.parse(formatOfDate);
            try {

                if (day < 1 || day > 31) {
                    throw new Error();
                }

                //check year les than zero
                if (year < 0) {
                    throw new Error();
                }

                //check month = 4 or 6 or 9 or 11
                if (month == 4 || month == 6 || month == 9 || month == 11) {
                    //compare day equal 31
                    if (day == 31) {
                        throw new Error();
                    }

                }

                //check year divided by 4 remainder 0
                if (year % 4 == 0) {
                    //compare year divided by 100 remainder 0
                    if (year % 100 == 0) {
                        //compare year divided by 400 remainder 0
                        if (year % 400 == 0) {
                            //compare month equal 2 and day greater than 29
                            if (month == 2 && day > 29) {
                                throw new Error();
                            }
                        } else {
                            //compare month equal 2 and day large than 28
                            if (month == 2 && day > 28) {
                                throw new Error();
                            }
                        }
                    } else {
                        //compare month equal 2 and day large than 29
                        if (month == 2 && day > 29) {
                            throw new Error();
                        }
                    }
                } else {
                    //compare month equal 2 and day large than 28
                    if (month == 2 && day > 28) {
                        throw new Error();
                    }
                }

                //Date date = dateformat.parse(formatOfDate);
                if (date.after(dateCurrent)) {
                    throw new Error();
                }

                if ((Date) date != date) {
                    System.out.println("Date not exist");
                } else {
                    break;
                }

                //System.out.println(date);
            } catch (Error e) {
                System.out.println("Date not exist");
                //inputDateFormat("Please enter date with format [dd/mm/yyyy]: ");
                return true;
            }
            //check day less than 1 or day greater than 31

        }
        return true;
    }

    private static void dayOfInputDate(String msg, String formatOfDate) throws ParseException {
        //System.out.println(formatOfDate);
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateformat.parse(formatOfDate);
        SimpleDateFormat dayformat = new SimpleDateFormat("EEEE");
        System.out.println(msg + dayformat.format(date));
    }
}
