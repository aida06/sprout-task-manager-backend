package com.example.projectcoding0.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;


@TableName("schedule")
public class Schedule {

    @TableId(value = "schedule_id", type = IdType.AUTO)
    private Long scheduleId;

    @TableField("title")
    private String title;

//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX", timezone = "UTC")
    @TableField("start_time")
    private OffsetDateTime startTime;
//    private LocalDateTime startTime;

    @TableField("duration")
    private int duration;

    @TableField(value = "remind_before", updateStrategy = FieldStrategy.IGNORED)
    private Integer remindBefore;

    @TableField("user_id")
    private Long userId;

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Integer getRemindBefore() {
        return remindBefore;
    }

    public void setRemindBefore(Integer remindBefore) {
        this.remindBefore = remindBefore;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", duration=" + duration +
                ", remindBefore=" + remindBefore +
                ", userId=" + userId +
                '}';
    }
}
