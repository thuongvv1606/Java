/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Options {
    public static void addDoctor(ArrayList<Doctor> ld){
        System.out.println("--------- Add Doctor ----------");
        System.out.printf("Enter Code: ");
        String code = InputData.inputString();
        //check code exit or not
        if(!InputData.checkCodeExist(ld, code)) {
            System.out.println("Code is not null.");
            return;
        }
        System.out.printf("Enter Name: ");
        String name = InputData.inputString();
        System.out.printf("Enter Specialization: ");
        String specialization = InputData.inputString();
        System.out.printf("Enter Availability: ");
        int availability = InputData.inputInteger();
        ld.add(new Doctor(code, name, specialization, availability));
        System.out.println("Add successful.");
    }
    
    //get docter by code
    public static Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        //loop access from the first doctor to the last doctor in array list
        for (Doctor doctor : ld) {
            //compare code doctor
            if(doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }
    
    public static void updateDoctor(ArrayList<Doctor> ld) {
        System.out.println("--------- Update Doctor -------");
        System.out.printf("Enter code: ");
        String code = InputData.inputString();
        //check code exist or not
        if(InputData.checkCodeExist(ld, code)) {
            System.out.println("code does not exist Doctor");
            return;
        }
        Doctor doctor = getDoctorByCode(ld, code);
//        System.out.println("Enter code: ");
//        String codeUpdate = InputData.inputString();
        System.out.printf("Enter Name: ");
        String name = InputData.inputString();
        System.out.printf("Enter Specialization: ");
        String specialization = InputData.inputString();
        System.out.printf("Enter Availability: ");
        int availability = InputData.inputInteger();
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.out.println("Update successful.");
    }
    
    //allow user delete doctor
    public static void deleteDoctor(ArrayList<Doctor> ld) {
        System.out.println("--------- Delete Doctor -------");
        System.out.printf("Enter code: ");
        String code = InputData.inputString();
        Doctor doctor = getDoctorByCode(ld, code);
        if(doctor == null) {
            System.out.println("Not found doctor.");
        }else {
            ld.remove(doctor);
        }
        System.out.println("Delete successful.");
    }
}
