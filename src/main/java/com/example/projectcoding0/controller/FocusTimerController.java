package com.example.projectcoding0.controller;

import com.example.projectcoding0.entity.FocusTimer;
import com.example.projectcoding0.mapper.FocusTimerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/focusTimer")
public class FocusTimerController {

    @Autowired
    private FocusTimerMapper focusTimerMapper;

    @PostMapping("/saveFocus")
    public String saveFocus(@RequestBody FocusTimer timer) {

        FocusTimer focusTimer = new FocusTimer();
        focusTimer.setUserId(timer.getUserId());
        focusTimer.setTaskName(timer.getTaskName());
        focusTimer.setDuration(timer.getDuration());
        focusTimer.setSuccessful(timer.getSuccessful());
        focusTimer.setStartTime(timer.getStartTime());
        focusTimer.setEndTime(timer.getEndTime());

        focusTimerMapper.insert(focusTimer);

        return "Focus timer saved successfully";
    }


    // Get all user focus timers
    @GetMapping
    public List<FocusTimer> getAllFocusTimer(){
        return focusTimerMapper.selectAllFocusTimers();
    }


}
