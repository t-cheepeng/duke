package com.chee.model;

import java.util.List;

public class TaskList {

    private List<Task> taskList;

    public TaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public Task remove(int index) {
        return taskList.remove(index);
    }

    public void add(Task task) {
        taskList.add(task);
    }

    public int size() {
        return taskList.size();
    }

    public Task get(int index) { return taskList.get(index); }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
