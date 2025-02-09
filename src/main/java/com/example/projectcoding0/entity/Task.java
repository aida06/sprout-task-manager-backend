package com.example.projectcoding0.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("task")
public class Task {
    @TableId(value = "task_id", type = IdType.AUTO)
    private Long taskId;
    @TableField("task_name")
    private String taskName;
    @TableField("description")
    private String description;
    @TableField("is_completed")
    private boolean isCompleted;

    @TableField("user_id")
    private User user;  // Associate to User

    // Getters and Setters
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskID='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                ", userID='" + user + '\'' +
                '}';
    }
}

