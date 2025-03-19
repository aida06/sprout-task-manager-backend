package com.example.projectcoding0.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.projectcoding0.entity.UserBelongings;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface UserBelongingsMapper extends BaseMapper<UserBelongings> {


    @Update("UPDATE user_belongings SET location_x = #{locationX}, location_y = #{locationY} WHERE belongings_id = #{belongingId}")
    void updateLocation(@Param("belongingId") Long belongingId, @Param("locationX") int locationX, @Param("locationY") int locationY);


    // Custom method: Get belongings by userId
    @Select("SELECT * FROM user_belongings WHERE user_id = #{userId}")
    List<UserBelongings> selectByUid(Long userId);

    // 查询 user_belongings 及其关联的 user 和 item
    @Select("SELECT * FROM user_belongings")
    @Results({
            @Result(column = "belongings_id", property = "belongingsId"),
            @Result(column = "location_x", property = "locationX"),
            @Result(column = "location_y", property = "locationY"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "item_id", property = "itemId"),
    })
    List<UserBelongings> selectWithUserAndItem();


}
