package sia.mansys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface TgSettingMapper {

	// searchKaisyaAll
	@Select("SELECT category2,value1 FROM tg_setting WHERE category1=#{category1} AND category3=#{category3}")
	List<Map<Integer, String>> getC2sV1sByC1C3(@Param("category1")int category1, @Param("category3")int category3);
	
	// searchKaisyaMaps
	@Select("SELECT category2,value1 FROM tg_setting WHERE category1=#{category1} AND category3=#{category3} AND category2 IN (${category2s}) ORDER BY category2")
	List<Map<Integer, String>> getC2V1ByC1C2sC3(@Param("category1")int category1, @Param("category2s")List<Integer> category2s, @Param("category3")int category3);
	
	// searchKaisya
	@Select("SELECT value2 FROM tg_setting WHERE category1=#{category1} AND category2=#{category2} AND category3=#{category3}")
	String getV2ByC1C2C3(@Param("category1")int category1, @Param("category2")int category2, @Param("category3")int category3);
	
	// searchSyokugyoAll
	@Select("SELECT category3,value1 FROM tg_setting WHERE category1=#{category1} AND category2=#{category2} ORDER BY category3")
	List<Map<Integer, String>> getC3sV1sByC1C2(@Param("category1")int category1, @Param("category2")int category2);
	
	// searchSyokugyoMaps
	@Select("SELECT category3,value1 FROM tg_setting WHERE category1=#{category1} AND category2=#{category2} AND category3 IN (${category3s}) ORDER BY category3")
	List<Map<Integer, String>> getC3sV1sByC1C2C3s(@Param("category1")int category1, @Param("category2")int category2, @Param("category3s")List<Integer> category3s);
	
	// searchSyokugyo
	@Select("SELECT value1 FROM tg_setting WHERE category1=#{category1} AND category2=#{category2} AND category3=#{category3}")
	String getV1ByC1C2C3(@Param("category1")int category1, @Param("category2")int category2, @Param("category3")int category3);
}
