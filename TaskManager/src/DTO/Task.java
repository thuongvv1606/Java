/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author hp
 */
public class Task {
    //bien static la thuoc ve class chu ko phai thuoc ve doi tuong
    private static int auto_Increment = 1;
    private int id;
    private String requirementName, date, assignee, reviewer;
    private double from, to;
    private int taskType;

    public Task(String requirementName, String date, String assignee, String reviewer, double from, double to, int taskType) {
        this.id = auto_Increment++;
        this.requirementName = requirementName;
        this.date = date;
        this.assignee = assignee;
        this.reviewer = reviewer;
        this.from = from;
        this.to = to;
        this.taskType = taskType;
    }

    public Task() {
        id = auto_Increment++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getTaskTypeString() {
        String result = null;
        switch (taskType) {
            case 1:
                result = "Code";
                break;
            case 2:
                result = "Test";
                break;
            case 3:
                result = "Design";
                break;
            case 4:
                result = "Review";
                break;
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s", id, requirementName,getTaskTypeString(),
                date,to - from, assignee, reviewer );
    }
    
    
    

}

