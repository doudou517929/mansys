package sia.mansys.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import sia.mansys.model.UserAccessLog;

@Mapper
public interface UserAccessLogMapper {
    @Insert("INSERT INTO user_access_log(user_id, gamen_id, start_time) VALUES (#{USER_ID}, #{GAMEN_ID}, #{START_TIME})")
    void insertUserAccessLog(UserAccessLog userAccessLog);

    @Select("SELECT START_TIME FROM user_access_log WHERE USER_ID = #{userId} AND GAMEN_ID = 'login.jsp' ORDER BY START_TIME DESC LIMIT 1")
    Date getDate(@Param("userId") Integer userId);
    
}
