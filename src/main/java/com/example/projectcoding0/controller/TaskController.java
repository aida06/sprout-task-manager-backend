package com.example.projectcoding0.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.projectcoding0.entity.Task;
import com.example.projectcoding0.entity.User;
import com.example.projectcoding0.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskMapper taskMapper;


    // Query all tasks with their associated users
    @GetMapping("/users")
    public List<Task> getAllTasksWithUsers() {
        List<Task> taskList = taskMapper.selectAllTasksWithUsers();  // 调用 TaskMapper 中的自定义查询方法
        System.out.println(taskList);
        return taskList;
    }

    // Query all tasks
    @GetMapping
    public List<Task> queryTasks() {
        List<Task> list = taskMapper.selectList(null);
        System.out.println(list);
        return list;
    }

    // Create a new task
    @PostMapping
    public String createTask(@RequestBody Task task) {
        int result = taskMapper.insert(task);
        if (result > 0) {
            return "Task created successfully!";
        } else {
            return "Failed to create task.";
        }
    }

    //条件查询
    @GetMapping("/users/{userId}")
    public List<Task> getTasksByUser(@PathVariable Long userId) {
        // 1. 创建 QueryWrapper 对象，用于构建查询条件
        com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<Task> queryWrapper =
                new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<>();

        // 2. 设置查询条件：筛选出 userID 等于传入参数的任务
        queryWrapper.eq("user_id", userId);  // 相当于 SQL: WHERE userID = #{userID}

        // 3. 调用 MyBatis-Plus 提供的 selectList 方法执行查询
        List<Task> taskList = taskMapper.selectList(queryWrapper);

        // 4. 打印结果以便调试（可选）
        System.out.println("Tasks for userID " + userId + ": " + taskList);

        // 5. 返回查询结果
        return taskList;
    }

    //分页查询
    @GetMapping("/findByPage")
    public IPage findTasksByPage() {
        Page<Task> page = new Page<>(0, 2);  // 设置分页的当前页和每页显示的数量
        IPage iPage = taskMapper.selectPage(page, null);  // MyBatis-Plus的分页查询
        return iPage;
    }


}

