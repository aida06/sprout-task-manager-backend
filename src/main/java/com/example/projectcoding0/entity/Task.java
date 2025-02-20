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
    @TableField("importance")
    private Integer importance;
    @TableField("urgency")
    private Integer urgency;
    @TableField("task_tag")
    private String taskTag;
    @TableField("description")
    private String description;
    @TableField("reward_coins")
    private float rewardCoins;
    @TableField("focus_time")
    private Integer focusTime;

    @TableField("user_id")
//    private User user;  // Associate to User
    private Long userId;


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


    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public Integer getUrgency() {
        return urgency;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
    }

    public String getTaskTag() {
        return taskTag;
    }

    public void setTaskTag(String taskTag) {
        this.taskTag = taskTag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public float getRewardCoins() {
        return rewardCoins;
    }

    public void setRewardCoins(float rewardCoins) {
        this.rewardCoins = rewardCoins;
    }

    public Integer getFocusTime() {
        return focusTime;
    }

    public void setFocusTime(Integer focusTime) {
        this.focusTime = focusTime;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", importance=" + importance +
                ", urgency=" + urgency +
                ", taskTag='" + taskTag + '\'' +
                ", description='" + description + '\'' +
                ", rewardCoins=" + rewardCoins +
                ", focusTime=" + focusTime +
                ", userId=" + userId +
                '}';
    }
}

