/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.Input;
import Data.Options;
import Data.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author hp
 */
public class StudentManager {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        System.out.println("====== Management Student Program ======");
        Options op = new Options();
        while (true) {            
            String name = Input.InputString("Name:");
            String classes = Input.InputString("Classes:");
            double math = Input.InputMark("Maths");
            double chemistry = Input.InputMark("Chemistry");
            double physical = Input.InputMark("Physics");
            op.addStudent(list, name, classes, math, physical, chemistry);
            boolean t = Input.checkYN("Do you want to enter more student information?(Y/N):");
            if(t == false) {
                break;
            } 
        }
            op.display(list);
            System.out.println("--------Classification Info -----");            
            HashMap<String, Double> mapStudent = op.getPercentTypeStudent(list);
            mapStudent.forEach((key, value) -> System.out.println(key + ": " + value + "%"));
        
    }
}
