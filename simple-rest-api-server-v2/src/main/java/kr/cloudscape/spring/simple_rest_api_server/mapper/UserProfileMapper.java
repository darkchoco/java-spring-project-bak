package kr.cloudscape.spring.simple_rest_api_server.mapper;

import kr.cloudscape.spring.simple_rest_api_server.model.UserProfile;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserProfileMapper {

    @Select("SELECT * FROM user_profile WHERE id = #{id}")
    UserProfile getUserProfile(@Param("id") String id);

    @Select("SELECT * FROM user_profile")
    List<UserProfile> getUserProfileList();

    @Insert("INSERT INTO user_profile VALUES (#{id}, #{name}, #{phone}, #{address})")
    int insertUserProfile(@Param("id") String id,
                          @Param("name") String name,
                          @Param("phone") String phone,
                          @Param("address") String address);

    @Update("UPDATE user_profile SET name = #{name}, phone = #{phone}, address = #{address} WHERE id = #{id}")
    int updateUserProfile(@Param("id") String id,
                          @Param("name") String name,
                          @Param("phone") String phone,
                          @Param("address") String address);

    @Delete("DELETE FROM user_profile WHERE id = #{id}")
    int deleteUserProfile(@Param("id") String id);
}
