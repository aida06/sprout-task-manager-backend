package com.example.projectcoding0.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.List;


@TableName("user")
public class User {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;         // Unique identifier (Primary Key)
    @TableField("user_name")      // Map to the username column
    private String userName;
    @TableField("user_password")
    private String password;
    @TableField("user_coins")
    private float userCoins;
    // Associated task
    @TableField(exist = false)   // This field is not mapped to the database
    private List<Task> tasks;  // One user <-> Multiple tasks


    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getUserCoins() {
        return userCoins;
    }

    public void setUserCoins(float userCoins) {
        this.userCoins = userCoins;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userCoins=" + userCoins +
                ", tasks=" + tasks +
                '}';
    }
}

