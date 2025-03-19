package com.example.projectcoding0.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@TableName("focus_timer")
public class FocusTimer {

        @TableId(value = "timer_id", type = IdType.AUTO)
        private Long timerId;

        @TableField("task_name")
        private String taskName;

        @TableField("duration")
        private int duration;

        @TableField("successful")
        private boolean successful;

        @TableField("start_time")
        private LocalDateTime startTime;

        @TableField("end_time")
        private LocalDateTime endTime;

        @TableField("user_id")
        private Long userId;


    public Long getTimerId() {
        return timerId;
    }

    public void setTimerId(Long timerId) {
        this.timerId = timerId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FocusTimer{" +
                "timerId=" + timerId +
                ", taskName='" + taskName + '\'' +
                ", duration=" + duration +
                ", successful=" + successful +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", userId=" + userId +
                '}';
    }


}




