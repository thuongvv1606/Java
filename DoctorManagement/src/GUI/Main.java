/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.*;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Doctor> ld = new ArrayList<>();
        InputData getdata = new InputData();
        Options o = new Options();
        int choice;
        while (true) {            
            Display.displayMenu();
            choice = InputData.inputIntLimit(1 , 5);
            switch(choice){
                case 1:{
                    Options.addDoctor(ld);
                    break;
                }
                case 2:{
                    Options.updateDoctor(ld);
                    break;
                }
                case 3:{
                    break;
                }
                case 4:{
                        
                    break;
                }
                case 5:{
                    System.exit(0);
                }
            }
        }
    }

    
}
