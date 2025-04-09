package com.example.projectcoding0.controller;

import com.example.projectcoding0.entity.Schedule;
import com.example.projectcoding0.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @DeleteMapping("/deleteReminder/{id}")
    public String deleteReminder(@PathVariable Long id) {
        int rows = scheduleMapper.deleteById(id);
        if (rows > 0) {
            return "Schedule deleted successfully!";
        } else {
            return "No schedule record found or delete failed!";
        }
    }

    @PutMapping("/updateReminder")
    public String updateReminder(@RequestBody Schedule schedule) {
        // MyBatis-Plus 根据主键（scheduleId）更新
        int rows = scheduleMapper.updateById(schedule);
        if (rows > 0) {
            return "Schedule updated successfully!";
        } else {
            return "No schedule record found or update failed!";
        }
    }


    @PostMapping("/createReminder")
    public String createReminder(@RequestBody Schedule schedule) {

        scheduleMapper.insert(schedule);
        return "Schedule created successfully!";
    }


    @GetMapping
    public List<Schedule> getAllSchedule(){
        return scheduleMapper.selectAllSchedule();
    }


}
