package com.example.projectcoding0.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.projectcoding0.entity.Task;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface TaskMapper extends BaseMapper<Task> {


    // **删除任务**
    @Delete("DELETE FROM task WHERE task_id = #{taskId}")
    int deleteTask(@Param("taskId") int taskId);


    @Update("UPDATE task " +
            "SET task_name = #{task.taskName}, " +
            "    importance = #{task.importance}, " +
            "    urgency = #{task.urgency}, " +
            "    description = #{task.description}, " +
            "    reward_coins = #{task.rewardCoins} " +
            "WHERE task_id = #{task.taskId}")
    int updateTask(@Param("task") Task updatedTask);


    @Select("SELECT COUNT(*) FROM task WHERE task_tag = #{oldTag} AND user_id = #{userId}")
    int countTag(@Param("oldTag") String oldTag, @Param("userId") int userId);

    // Rename tag
    @Update("UPDATE task SET task_tag = #{newTag} WHERE task_tag = #{oldTag} AND user_id = #{userId}")
    int renameTag(@Param("oldTag") String oldTag, @Param("newTag") String newTag, @Param("userId") int userId);

    // Delete tag
    @Delete("DELETE FROM task WHERE task_tag = #{taskTag} AND user_id = #{userId}")
    int deleteTag(@Param("taskTag") String tag, @Param("userId") int userId);


    // Custom method: Get tasks by userId
    @Select("SELECT * FROM task WHERE user_id = #{userId}")
    List<Task> selectByUid(Long userId);

    // 查询所有任务，同时查询任务的用户
    @Select("SELECT * FROM task")
    @Results({
            @Result(column = "task_id", property = "taskId"),
            @Result(column = "task_name", property = "taskName"),
            @Result(column = "importance", property = "importance"),
            @Result(column = "urgency", property = "urgency"),
            @Result(column = "task_tag", property = "taskTag"),
            @Result(column = "description", property = "description"),
            @Result(column = "reward_coins", property = "rewardCoins"),
            @Result(column = "focus_time", property = "focusTime"),
            @Result(column = "user_id", property = "userId")
    })
    List<Task> selectAllTasksWithUsers();

}

