package com.example.projectcoding0.controller;

import com.example.projectcoding0.entity.UserBelongings;
import com.example.projectcoding0.mapper.UserBelongingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/userBelongings")
public class UserBelongingsController {

    @Autowired
    private UserBelongingsMapper userBelongingsMapper;


    @PutMapping("/update/{belongingId}")
    public ResponseEntity<String> updateBelonging(
            @PathVariable Long belongingId,
            @RequestBody Map<String, Integer> requestBody) {
        try {
            int locationX = requestBody.get("locationX");
            int locationY = requestBody.get("locationY");

            System.out.println("Received belongingId: " + belongingId);
            System.out.println("Received locationX: " + locationX + ", locationY: " + locationY);

            userBelongingsMapper.updateLocation(belongingId, locationX, locationY);
            return ResponseEntity.ok("Belonging updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update belonging.");
        }
    }


    @DeleteMapping("/delete/{belongingId}")
    public ResponseEntity<String> deleteBelonging(@PathVariable Long belongingId) {
        try {
            userBelongingsMapper.deleteById(belongingId);
            return ResponseEntity.ok("Item deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete item.");
        }
    }


    @PostMapping("/add")
    public ResponseEntity<String> addBelonging(@RequestBody UserBelongings belonging) {
        try {
            userBelongingsMapper.insert(belonging);
            return ResponseEntity.ok("Item placed successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to place item.");
        }
    }

    // 条件查询用户的 belongings
    @GetMapping("/users/{userId}")
    public List<UserBelongings> getBelongingsByUser(@PathVariable Long userId) {
        // 1. 创建 QueryWrapper 对象，用于构建查询条件
        com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<UserBelongings> queryWrapper =
                new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<>();

        // 2. 设置查询条件：筛选出 userID 等于传入参数的 belongings
        queryWrapper.eq("user_id", userId);  // 相当于 SQL: WHERE user_id = #{userId}

        // 3. 调用 MyBatis-Plus 提供的 selectList 方法执行查询
        List<UserBelongings> belongingsList = userBelongingsMapper.selectList(queryWrapper);

        System.out.println("Belongings for userID " + userId + ": " + belongingsList);

        return belongingsList;
    }


    // Get all user belongings
    @GetMapping
    public List<UserBelongings> getAllBelongings() {
        return userBelongingsMapper.selectWithUserAndItem();
    }


}
