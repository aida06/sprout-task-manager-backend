package com.example.projectcoding0.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.projectcoding0.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<User> {

//    // Create: Insert a new user
//    @Insert("INSERT INTO user (username, password) VALUES (#{username}, #{password})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")  // For auto-increment primary key
//    int insertUser(User user);
//
//    // Read: Find all users
//    @Select("SELECT * FROM user")
//    List<User> findAll();
//
//    // Read: Find user by ID
//    @Select("SELECT * FROM user WHERE id = #{id}")
//    User findById(@Param("id") Long id);
//
//    // Update: Update user information
//    @Update("UPDATE user SET username = #{username}, password = #{password} WHERE id = #{id}")
//    int updateUser(User user);
//
//    // Delete: Delete a user by ID
//    @Delete("DELETE FROM user WHERE id = #{id}")
//    int deleteUser(@Param("id") Long id);

    // Custom method:
//    @Select("SELECT * FROM user WHERE user_id = #{userId}")
//    User selectById(Long userId);
    @Select("SELECT user_coins FROM user WHERE user_id = #{userId}")
    Float getUserCoins(@Param("userId") int userId);

//    @Update("UPDATE user SET user_coins = user_coins + #{rewardCoins} WHERE user_id = #{userId}")
//    Float addUserCoins(@Param("userId") int userId, @Param("rewardCoins") float rewardCoins);

    @Update("UPDATE user SET user_coins = user_coins + #{rewardCoins} WHERE user_id = #{userId}")
    int addUserCoins(@Param("userId") int userId, @Param("rewardCoins") float rewardCoins);


    // 查询用户及其所有任务
    @Select("SELECT * FROM user")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "user_password", property = "password"),
            @Result(column = "user_coins", property = "userCoins"),
            @Result(column = "user_id", property = "tasks",
                    javaType = List.class,
                    many = @Many(select = "com.example.projectcoding0.mapper.TaskMapper.selectByUid")
            )
    })
    List<User> selectAllUsersWithTasks();

}

