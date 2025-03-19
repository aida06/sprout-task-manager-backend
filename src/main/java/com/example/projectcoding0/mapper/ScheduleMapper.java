package com.example.projectcoding0.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.projectcoding0.entity.Schedule;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;


public interface ScheduleMapper extends BaseMapper<Schedule>  {


    // Custom method: Get focus timer by userId
    @Select("SELECT * FROM schedule WHERE user_id = #{userId}")
    List<Schedule> selectByUid(Long userId);


    @Select("SELECT * FROM schedule")
    @Results({
            @Result(column = "schedule_id", property = "scheduleId"),
            @Result(column = "title", property = "title"),
            @Result(column = "start_time", property = "startTime"),
            @Result(column = "duration", property = "duration"),
            @Result(column = "remind_before", property = "remindBefore"),
            @Result(column = "user_id", property = "userId")
    })
    List<Schedule> selectAllSchedule();



}
