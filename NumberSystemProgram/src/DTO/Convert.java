/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.math.BigInteger;
import java.util.HashMap;

/**
 *
 * @author hp
 */
public class Convert {

    final String Hex = "0123456789ABCDEF";

    //convert from binary to other base
    public String convertBin2Other(int baseOut, String valueIn) {
        BigInteger input = new BigInteger(valueIn);
        BigInteger result = new BigInteger("0");
        String finalResult = "";
        int power = 0;
        //check baseOut to perform correct algorithm
        if (baseOut == 2) {
            //loop until input value = 0
            do {
                //check if value = 0 to end converting
                if (!input.equals(new BigInteger("0"))) {
                    BigInteger remain = input.remainder(new BigInteger("2"));
                    result = result.add(remain.multiply(new BigInteger("2")).pow(power));
                    power++;
                    input = input.divide(new BigInteger("10"));
                } else {
                    finalResult = result.toString();
                    break;
                }
            } while (true);
        } else {
            HashMap<String, String> BinToHex = new HashMap<>();
            BinToHex.put("0000", "0");
            BinToHex.put("0001", "1");
            BinToHex.put("0010", "2");
            BinToHex.put("0011", "3");
            BinToHex.put("0100", "4");
            BinToHex.put("0101", "5");
            BinToHex.put("0110", "6");
            BinToHex.put("0111", "7");
            BinToHex.put("1000", "8");
            BinToHex.put("1001", "9");
            BinToHex.put("1010", "A");
            BinToHex.put("1011", "B");
            BinToHex.put("1100", "C");
            BinToHex.put("1101", "D");
            BinToHex.put("1110", "E");
            BinToHex.put("1111", "F");
            //check if input value divided by 4 to append 0 to beginning of string
            while (valueIn.length() % 4 != 0) {
                valueIn = "0" + valueIn;
            }
            //loop to access each substring of input value
            for (int i = 0; i < valueIn.length(); i += 4) {
                String key = valueIn.substring(i, i + 4);
                finalResult += BinToHex.get(key);
            }
        }
        return finalResult;
    }

    //convert from decimal to other base
    public String convertDec2Other(int baseOut, String valueIn) {
        BigInteger input = new BigInteger(valueIn);
        StringBuilder result = new StringBuilder();
        BigInteger baseOutput;
        //check baseOut to get correct BaseOutput
        if (baseOut == 1) {
            baseOutput = new BigInteger("2");
        } else {
            baseOutput = new BigInteger("16");
        }
        //loop until input value = 0
        do {
            BigInteger remain = input.remainder(baseOutput);
            char hexValue = Hex.charAt(remain.intValue());
            //check if value = 0 to end converting
            if (!input.equals(new BigInteger("0"))) {
                result = result.append(hexValue);
                input = input.divide(baseOutput);
            } else {
                return result.reverse().toString();
            }
        } while (true);
    }

    //convert from hexadecimal to other base
    public String convertHex2Other(int baseOut, String valueIn) {
        BigInteger result = new BigInteger("0");
        String finalResult = "";
        int power = 0;
        //check baseOut to perform correct algorithm 
        if (baseOut == 1) {
            HashMap<String, String> HexToBin = new HashMap<>();
            HexToBin.put("0", "0000");
            HexToBin.put("1", "0001");
            HexToBin.put("2", "0010");
            HexToBin.put("3", "0011");
            HexToBin.put("4", "0100");
            HexToBin.put("5", "0101");
            HexToBin.put("6", "0110");
            HexToBin.put("7", "0111");
            HexToBin.put("8", "1000");
            HexToBin.put("9", "1001");
            HexToBin.put("A", "1010");
            HexToBin.put("B", "1011");
            HexToBin.put("C", "1100");
            HexToBin.put("D", "1101");
            HexToBin.put("E", "1110");
            HexToBin.put("F", "1111");
            //loop to access each element of input value
            for (int i = 0; i < valueIn.length(); i++) {
                String key = Character.toString(valueIn.charAt(i));
                finalResult += HexToBin.get(key);
            }
        } else {
            //loop to access each element of input value
            for (int i = valueIn.length() - 1; i >= 0; i--) {
                int digit = Hex.indexOf(Character.toString(valueIn.charAt(i)));
                result = result.add(new BigInteger(Integer.toString(digit)).
                        multiply(new BigInteger("16").pow(power)));
                power++;
            }
            finalResult = result.toString();
        }
        return finalResult;
    }

    //convert result
    public String convertResult(int baseIn, int baseOut, String valueIn) {
        String result = "";
        //check baseIn to perform correct function
        switch (baseIn) {
            case 1:
                result = convertBin2Other(baseOut, valueIn);
                break;
            case 2:
                result = convertDec2Other(baseOut, valueIn);
                break;
            case 3:
                result = convertHex2Other(baseOut, valueIn);
                break;
        }
        return result;
    }
}
