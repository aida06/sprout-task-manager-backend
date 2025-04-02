package com.example.projectcoding0.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.projectcoding0.entity.StoreItem;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;


public interface StoreItemMapper extends BaseMapper<StoreItem> {


    @Select("SELECT item_id, frame_index FROM store_item")
    @Results({
            @Result(column = "item_id", property = "itemId"),
            @Result(column = "frame_index", property = "frameIndex")
    })
    List<StoreItem> selectFrameIndexMap();


    @Select("SELECT item_id, item_price FROM store_item")
    @Results({
            @Result(column = "item_id", property = "itemId"),
            @Result(column = "item_price", property = "itemPrice")
    })
    List<StoreItem> selectItemPriceMap();


    @Select("SELECT item_id, item_sprite FROM store_item")
    @Results({
            @Result(column = "item_id", property = "itemId"),
            @Result(column = "item_sprite", property = "itemSprite")
    })
    List<StoreItem> selectItemSpriteMap();


    @Select("SELECT * FROM store_item")
    @Results({
            @Result(column = "item_id", property = "itemId"),
            @Result(column = "item_name", property = "itemName"),
            @Result(column = "item_type", property = "itemType"),
            @Result(column = "item_price", property = "itemPrice"),
            @Result(column = "item_sprite", property = "itemSprite"),
            @Result(column = "frame_index", property = "frameIndex")
    })
    List<StoreItem> selectStoreItems();


}
