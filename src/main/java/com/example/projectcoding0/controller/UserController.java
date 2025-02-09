package com.example.projectcoding0.controller;

import com.example.projectcoding0.entity.User;
import com.example.projectcoding0.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/user")  // 统一路由前缀
public class UserController {

    @Autowired
    private UserMapper userMapper;

//    // Query all users
//    @GetMapping
//    public List<User> query() {
//        List<User> list = userMapper.findAll();
//        System.out.println(list);
//        return list;
//    }
//
//    // Create a new user
//    @PostMapping
//    public String createUser(@RequestBody User user) {
//        int result = userMapper.insertUser(user);
//        if (result > 0) {
//            return "User created successfully!";
//        } else {
//            return "Failed to create user.";
//        }
//    }
//
//    // Update user information
//    @PutMapping("/{id}")
//    public String updateUser(@PathVariable("id") Long id, @RequestBody User user) {
//        user.setId(id);  // Set the user ID to update
//        int result = userMapper.updateUser(user);
//        if (result > 0) {
//            return "User updated successfully!";
//        } else {
//            return "Failed to update user.";
//        }
//    }
//
//    // Delete a user
//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable("id") Long id) {
//        int result = userMapper.deleteUser(id);
//        if (result > 0) {
//            return "User deleted successfully!";
//        } else {
//            return "Failed to delete user.";
//        }
//    }

    // Query all users and their tasks
    @GetMapping("/tasks")
    public List<User> getAllUsersWithTasks() {
        List<User> list = userMapper.selectAllUsersWithTasks();  // 调用 UserMapper 的自定义查询方法
        System.out.println(list);
        return list;
    }

    // Query all users
    @GetMapping
    public List<User> query() {
        List<User> list = userMapper.selectList(null); // Use MyBatis-Plus built-in method
        System.out.println(list);
        return list;
    }

    // Create a new user
    @PostMapping
    public String createUser(@RequestBody User user) {
        int result = userMapper.insert(user); // Use BaseMapper's insert method
        if (result > 0) {
            return "User created successfully!";
        } else {
            return "Failed to create user.";
        }
    }

    // Update user information
    @PutMapping("/{user_id}")
    public String updateUser(@PathVariable("user_id") Long id, @RequestBody User user) {
        user.setUserId(id);  // Set the ID to ensure correct update
        int result = userMapper.updateById(user); // Use BaseMapper's updateById method
        if (result > 0) {
            return "User updated successfully!";
        } else {
            return "Failed to update user.";
        }
    }

    // Delete a user
    @DeleteMapping("/{user_id}")
    public String deleteUser(@PathVariable("user_id") Long id) {
        int result = userMapper.deleteById(id); // Use BaseMapper's deleteById method
        if (result > 0) {
            return "User deleted successfully!";
        } else {
            return "Failed to delete user.";
        }
    }



}

