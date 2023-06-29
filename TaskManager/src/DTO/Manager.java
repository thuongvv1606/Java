/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;

/**
 *
 * @author hp
 */
public class Manager {

    //ham de kiem tra xem tat ca cac thuoc tinh nhap vao co ko bi overlaps ko
    // => true => bi overlaps
    // => false => ko bi overlaps
    public boolean checkOverlaps(String date, String assignee, double from, double to, List<Task> listTask) {
        if (listTask.size() == 0) {
            return false;
        }

        //parameter: ki hieu la 2
        //task in list: ki hieu la 1
        for (Task task : listTask) {
            //if date and assignee of task equal to parameter then compare to plan To
            if (task.getDate().compareToIgnoreCase(date) == 0 && task.getAssignee().compareTo(assignee) == 0) {

                /*NOTE
            	 * from2 : parameter (user add on method "add task")
            	 * from1 : from of task already in list 
            	 * to2   : parameter ( user add on method "add task")
            	 * to1   : to of task already in list
            	 * */
                //if from2 < from1 && to2 > from1
                if (from < task.getFrom() && to > task.getFrom()) {
                    return true;
                }
                //if from2 = from1 and to2 > from1 => return true
                if (from == task.getFrom() && to > task.getFrom()) {
                    return true;
                }
                // if from2 > from1 and to2 >= to1  and from2 < to1=> return true
                if (from > task.getFrom() && to >= task.getTo()
                        && from < task.getTo()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Task getTaskByID(int id, List<Task> listTask) {
        for (Task task : listTask) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }


}
