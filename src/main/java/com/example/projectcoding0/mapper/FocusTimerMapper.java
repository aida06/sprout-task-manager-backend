package com.example.projectcoding0.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.projectcoding0.entity.FocusTimer;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface FocusTimerMapper extends BaseMapper<FocusTimer> {


    // Custom method: Get focus timer by userId
    @Select("SELECT * FROM focus_timer WHERE user_id = #{userId}")
    List<FocusTimer> selectByUid(Long userId);


    @Select("SELECT * FROM focus_timer")
    @Results({
            @Result(column = "timer_id", property = "timerId"),
            @Result(column = "task_name", property = "taskName"),
            @Result(column = "duration", property = "duration"),
            @Result(column = "successful", property = "successful"),
            @Result(column = "start_time", property = "startTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "user_id", property = "userId")
    })
    List<FocusTimer> selectAllFocusTimers();


}
