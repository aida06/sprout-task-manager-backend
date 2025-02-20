//package com.example.projectcoding0.mapper;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.example.projectcoding0.entity.Task;
//import com.example.projectcoding0.entity.User;
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//
//
//@Mapper
//public interface TaskMapperCopy extends BaseMapper<Task> {
//    // Basic CRUD operations are provided by BaseMapper
//    // - insert(Task task)
//    // - deleteById(Long id)
//    // - updateById(Task task)
//    // - selectById(Long id)
//    // - selectList(Wrapper<Task> wrapper)
//
//    // Custom method: Get tasks by userId
//    @Select("SELECT * FROM task WHERE user_id = #{userId}")
//    List<Task> selectByUid(Long userId);
//
//    // 查询所有任务，同时查询任务的用户
//    @Select("SELECT * FROM task")
//    @Results({
//            @Result(column = "task_id", property = "taskId"),
//            @Result(column = "task_name", property = "taskName"),
//            @Result(column = "importance", property = "importance"),
//            @Result(column = "urgency", property = "urgency"),
//            @Result(column = "task_tag", property = "taskTag"),
//            @Result(column = "description", property = "description"),
//            @Result(column = "reward_coins", property = "rewardCoins"),
//            @Result(column = "focus_time", property = "focusTime"),
//            @Result(column = "user_id", property = "user",
//                    javaType = User.class,
//                    one = @One(select = "com.example.projectcoding0.mapper.UserMapper.selectById")
//            )
//    })
//    List<Task> selectAllTasksWithUsers();
//
//}

