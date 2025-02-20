package com.example.projectcoding0.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.projectcoding0.entity.User;
import com.example.projectcoding0.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")  // 统一路由前缀
public class UserController {

    @Autowired
    private UserMapper userMapper;


    // **获取用户积分**
    @GetMapping("/coins")
    public ResponseEntity<Float> getUserCoins(@RequestParam int userId) {
        Float coins = userMapper.getUserCoins(userId);
        return ResponseEntity.ok(coins != null ? coins : 0);
    }

    // **更新用户积分**
    @PostMapping("/updateCoins")
    public ResponseEntity<String> updateUserCoins(@RequestBody Map<String, Object> payload) {
        try {
            int userId = Integer.parseInt(payload.get("userId").toString());  // 解析成 int
            float rewardCoins = Float.parseFloat(payload.get("rewardCoins").toString());  // 解析成 float

            int updatedRows = userMapper.addUserCoins(userId, rewardCoins);
            if (updatedRows > 0) {
                return ResponseEntity.ok("User coins updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request: " + e.getMessage());
        }
    }



    // 用户登录（直接匹配数据库密码）
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_name", username));
        System.out.println("Queried user: " + user);
        if (user != null && user.getPassword().equals(password)) {
            return ResponseEntity.ok(Map.of("message", "Login successful", "userId", user.getUserId()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid username or password"));
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        // 验证输入是否合法
        if (username.isEmpty() || password.length() < 8) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Please enter username and password"));
        }

        // 检查数据库中是否已存在相同用户名
        User existingUser = userMapper.selectOne(new QueryWrapper<User>().eq("user_name", username));
        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Username already exists"));
        }

        // 创建新用户并存入数据库
        User newUser = new User();
        newUser.setUserName(username);
        newUser.setPassword(password);  // 这里没加密，生产环境建议加密

        int result = userMapper.insert(newUser);
        if (result > 0) {
            return ResponseEntity.ok(Map.of("message", "User registered successfully", "userId", newUser.getUserId()));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Registration failed"));
        }
    }

    @GetMapping("/check-existUser")
    public ResponseEntity<?> checkUsernameExists(@RequestParam String username) {
        boolean exists = userMapper.selectOne(new QueryWrapper<User>().eq("user_name", username)) != null;
        return ResponseEntity.ok(Map.of("exists", exists));
    }

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

