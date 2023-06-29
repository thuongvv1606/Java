/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import com.sun.xml.internal.bind.v2.model.core.ID;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hp
 */
public class View_Task {
    Manager manage = new Manager();
    
    
    public void inputTask(List<Task> listTask) {
        //input properties
        String name = getName();
        int taskType = getTaskType();
        String date = getDate();
        double from = getFrom();
        double to = getTo(from);
        String assignee = getAssignee();
        String reviewer = getReviewer();
        
        //check overlaps => date, assignee , from ,to
        //true => tell error
        //else => creat instance and add to list
        if (manage.checkOverlaps(date, assignee, from, to,listTask)) {
            System.out.println("Overlaps task !!!\n");
        }else {
            Task task = new Task(name, date, assignee, reviewer, from, to, taskType);
            listTask.add(task);
        }
    }

    private String getName() {
        String name = Ultility.getString("Enter name: ", Ultility.REGEX_STRING, "Wrong");
        return name;
    }

    private int getTaskType() {
        int tasktType = Ultility.getInt("Enter task type: ", 1, 4);
        return tasktType;
    }

    private String getDate() {
        String date = Ultility.inputDate("Enter date: ");
        return date;
    }

    private double getFrom() {
        double from = Ultility.getDouble("Enter from: ", 8, 17);
        return from;
    }

    private double getTo(double from) {
        double to = Ultility.getDouble("Enter to: ", from + 0.5, 17.5);
        return to;
    }

    private String getAssignee() {
        String assignee = Ultility.getString("Enter assignee: ", Ultility.REGEX_STRING, "Wrong");
        return assignee;
    }

    private String getReviewer() {
        String reviewer = Ultility.getString("Enter reviewer: ", Ultility.REGEX_STRING, "Wrong");
        return reviewer;
    }

    public void deleteTask(List<Task> listTask) {
        int id = getId();
        Task task = manage.getTaskByID(id, listTask);
        
        if (task == null) {
            System.out.println("NOT FOUND");
        }else {
            listTask.remove(task);
        }
        
    }

    public int getId() {
        int id =Ultility.getInt("Enter id: ", 1, Integer.MAX_VALUE);
        return id;
    }

    public void displayTask(List<Task> listTask) {
        if (listTask.size() == 0) {
            System.out.println("LIST IS EMPTY");
            return;
        }
        
        System.out.println("----------------------------------------- Task ---------------------------------------");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name","TaskType",
                "Date","Time", "Assignee", "Reviewer");
        
        for (Task task : listTask) {
           
            System.out.println(task);
        }
    }
}
