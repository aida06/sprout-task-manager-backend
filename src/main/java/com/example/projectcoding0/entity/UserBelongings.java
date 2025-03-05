package com.example.projectcoding0.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("user_belongings")
public class UserBelongings {

    @TableId(value = "belongings_id", type = IdType.AUTO)
    private Long belongingsId;
    @TableField("location_x")
    private int locationX;
    @TableField("location_y")
    private int locationY;
    @TableField("user_id")
    private Long userId;
    @TableField("item_id")
    private Long itemId;


    // Getters and Setters
    public Long getBelongingsId() {
        return belongingsId;
    }

    public void setBelongingsId(Long belongingsId) {
        this.belongingsId = belongingsId;
    }

    public float getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public float getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "UserBelongings{" +
                "belongingsId=" + belongingsId +
                ", locationX=" + locationX +
                ", locationY=" + locationY +
                ", userId=" + userId +
                ", itemId=" + itemId +
                '}';
    }
}
