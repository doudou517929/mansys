package sia.mansys.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import sia.mansys.model.UserAccessLog;

@Mapper
public interface UserAccessLogMapper {
    @Insert("INSERT INTO user_access_log(user_id, gamen_id, start_time) VALUES (#{USER_ID}, #{GAMEN_ID}, #{START_TIME})")
    void insertUserAccessLog(UserAccessLog userAccessLog);

}
