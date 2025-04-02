package com.example.projectcoding0.controller;

import com.example.projectcoding0.entity.StoreItem;
import com.example.projectcoding0.mapper.StoreItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/storeItems")
public class StoreItemController {

    @Autowired
    private StoreItemMapper storeItemMapper;


    @GetMapping("/frameIndexMap")
    public Map<Long, Integer> getFrameIndexMap() {
        List<StoreItem> itemList = storeItemMapper.selectFrameIndexMap();

        Map<Long, Integer> frameIndexMap = new HashMap<>();
        for (StoreItem item : itemList) {
            frameIndexMap.put(item.getItemId(),
                    item.getFrameIndex() != null ? item.getFrameIndex() : 0); // 为空时默认 0
        }
        return frameIndexMap;
    }


    @GetMapping("/itemPriceMap")
    public Map<Long, Float> getItemPriceMap() {
        // 查询出只包含 item_id 和 item_price 的 StoreItem列表
        List<StoreItem> itemList = storeItemMapper.selectItemPriceMap();

        // 封装成 Map<item_id, item_price>
        Map<Long, Float> itemPriceMap = new HashMap<>();
        for (StoreItem item : itemList) {
            itemPriceMap.put(item.getItemId(), item.getItemPrice());
        }
        return itemPriceMap;
    }


    @GetMapping("/itemSpriteMap")
    public Map<Long, String> getItemSpriteMap() {
        List<StoreItem> itemList = storeItemMapper.selectItemSpriteMap();

        Map<Long, String> itemSpriteMap = new HashMap<>();
        for (StoreItem item : itemList) {
            itemSpriteMap.put(item.getItemId(), item.getItemSprite());
        }
        return itemSpriteMap;
    }


    // Get all store items
    @GetMapping
    public List<StoreItem> getAllStoreItems() {
        return storeItemMapper.selectStoreItems();
    }

}

