package sia.mansys.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import sia.mansys.model.UserAccessLog;

@Mapper
public interface UserAccessLogMapper {
    void insertUserAccessLog(@Param("userAccessLog") UserAccessLog userAccessLog);
    Date getDate(@Param("userId") Integer userId);
}
