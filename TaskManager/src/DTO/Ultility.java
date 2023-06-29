/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Ultility {

    public static final Scanner scanner = new Scanner(System.in);
    public static final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public static final String REGEX_EMAIL = "[\\w]+[@]([\\w]+[.]){1,2}[\\w]+";
    public static final String REGEX_PHONE = "[0][0-9]{9,10}";
    public static final String REGEX_YN = "[yYnN]";
    static final String REGEX_DATE = "\\d{1,2}[-]\\d{1,2}[-]\\d{4}";
    static final String DATE_FORMAT = "dd-MM-yyyy";

    static String inputDate(String message) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            //b1: Input date
            System.out.print("Please enter the " + message);
            String input = scanner.nextLine();
            
            //if input is empty => tell error
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!!");
            } else {
                //if input matches with regex => return string
                //else tell error
                if (input.matches(REGEX_DATE) == false) {
                    System.out.println("Input must be in format [dd-mm-yyyy]");
                } else if (checkDateExist(input) == false) {
                    System.out.println("Date does not exist !!");
                }else if(checkLessThanCurrentDate(input) == false) {
                    System.out.println("Date must be greater or equal to current date !!");
                }else {
                    return input;
                }
            }
        }

    }
    
    //kiem tra xem ngay thang nhap vao co be hon ngay thang hien tai
    public static boolean checkLessThanCurrentDate(String input) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date currentDate = new Date();
            String currentDateString = dateFormat.format(currentDate);
            Date inputDate = dateFormat.parse(input);
            currentDate = dateFormat.parse(currentDateString);
            
            //neu nhu input date < current date => true
            //else => return false
            if (inputDate.equals(currentDate) || inputDate.after(currentDate)) {
                return false;
            }else {
                return true;
            }
            
        } catch (ParseException ex) {
            return false;
        }
    }

    public static boolean checkDateExist(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false);

        Date dateInput = new Date();
        try {
            dateInput = dateFormat.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    public static int getInt(String message, int min, int max) {

        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println("must in range " + min + " <= number <= " + max);
                    }
                }
            } catch (NumberFormatException exception) {
                System.out.println("Input must be a integer number");
            }

        }

    }

    public static double getDouble(String message, double min, double max) {

        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    double number = Double.parseDouble(input);
                    if (!(number % 0.5 == 0)) {
                        System.out.println("Input must be divide to 0.5");
                    }
                    else if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println("must in range " + min + " <= number <= " + max);
                    }
                }
            } catch (NumberFormatException exception) {
                System.out.println("Input must be a integer number");
            }

        }

    }

    public static float getFloat(String message, float min, float max) {

        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    float number = Float.parseFloat(input);
                    if (number > min && number <= max) {
                        return number;
                    } else {
                        System.out.println("must in range " + min + " <= number <= " + max);
                    }
                }
            } catch (NumberFormatException exception) {
                System.out.println("Input must be a integer number");
            }

        }

    }

//    public static double getDouble() {
//    }
//    public static String getString() {
//
//        
//    }
    public static String getString(String message, String regex, String error) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty");
            } else {
                //if input matches regex => return input
                // else print error
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }

    }
}


