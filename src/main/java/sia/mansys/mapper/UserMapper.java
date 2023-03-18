package sia.mansys.mapper;

import org.apache.ibatis.annotations.*;
import sia.mansys.model.User;
@Mapper
public interface UserMapper {

    @Select("SELECT USER_ID, USER_CODE, USER_NAME, PASSWORD, USER_ROLE, IS_YOUKOU FROM user_auth WHERE USER_CODE = #{userCode}")
    User findByCode(@Param("userCode") String userCode);
}

