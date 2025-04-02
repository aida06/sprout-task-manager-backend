package com.example.projectcoding0.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("store_item")
public class StoreItem {
    @TableId(value = "item_id", type = IdType.AUTO)
    private Long itemId;
    @TableField("item_name")
    private String itemName;
    @TableField("item_type")
    private String itemType;
    @TableField("item_price")
    private float itemPrice;
    @TableField("item_sprite")
    private String itemSprite;
    @TableField("frame_index")
    private Integer frameIndex;


    // Getters and Setters
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemSprite() {
        return itemSprite;
    }

    public void setItemSprite(String itemSprite) {
        this.itemSprite = itemSprite;
    }

    public Integer getFrameIndex() {
        return frameIndex;
    }

    public void setFrameIndex(Integer frameIndex) {
        this.frameIndex = frameIndex;
    }

    @Override
    public String toString() {
        return "StoreItem{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemSprite='" + itemSprite + '\'' +
                ", frameIndex=" + frameIndex +
                '}';
    }
}
