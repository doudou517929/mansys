package sia.mansys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import sia.mansys.model.User;
@Mapper
public interface UserMapper {

    User findByCode(@Param("userCode") String userCode);
}

