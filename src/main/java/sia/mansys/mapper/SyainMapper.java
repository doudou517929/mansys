package sia.mansys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.MappedTypes;

import sia.mansys.DTO.SearchSyainDTO;
import sia.mansys.DTO.SyainResultDTO;
import sia.mansys.model.SyainMain;

@Mapper
@MappedTypes({SyainMain.class, SyainResultDTO.class})
public interface SyainMapper {

	@Select("SELECT SYAIN_ID,SYOZOKU_KAISYA,FIRST_NAME_KANJI,LAST_NAME_KANJI,SEIBETU,SYOKUGYO_KIND,NYUUSYA_DATE,TAISYA_DATE FROM SYAIN_MAIN "
			+ "WHERE (#{searchSyainDTO.syozoku_kaisya} = 0 OR SYOZOKU_KAISYA=#{searchSyainDTO.syozoku_kaisya}) "
			+ "AND (#{searchSyainDTO.nameKanji} IS NULL OR CONCAT(FIRST_NAME_KANJI,LAST_NAME_KANJI) LIKE #{searchSyainDTO.nameKanji}) "
			+ "AND (#{searchSyainDTO.syokugyo_kind} IS NULL OR SYOKUGYO_KIND=#{searchSyainDTO.syokugyo_kind}) "
			+ "AND (#{searchSyainDTO.TAISYA} IS NULL OR TAISYA_DATE IS NOT NULL) "
			+ "AND (#{searchSyainDTO.ZAISYA} IS NULL OR TAISYA_DATE IS NULL) "
			+ "AND (DELETE_FLAG=0) "
			+ "ORDER BY FIRST_NAME_KANJI,LAST_NAME_KANJI")
	@Results(id = "searchSyain", value = {
			@Result(property = "syainId", column = "SYAIN_ID"),
			@Result(property = "syozokuKaisya", column = "SYOZOKU_KAISYA"),
			@Result(property = "firstNameKanji", column = "FIRST_NAME_KANJI"),
			@Result(property = "lastNameKanji", column = "LAST_NAME_KANJI"),
			@Result(property = "seibetu", column = "SEIBETU"),
			@Result(property = "syokugyoKind", column = "SYOKUGYO_KIND"),
			@Result(property = "nyuusyaDate", column = "NYUUSYA_DATE"),
			@Result(property = "taisyaDate", column = "TAISYA_DATE")
	})
	List<SyainResultDTO> searchSyain(@Param("searchSyainDTO")SearchSyainDTO searchSyainDTO);
	
	@Select("SELECT DISTINCT SYOZOKU_KAISYA FROM SYAIN_MAIN ORDER BY SYOZOKU_KAISYA")
	List<Integer> getKaisya();
	
	@Select("SELECT DISTINCT SYOKUGYO_KIND FROM SYAIN_MAIN ORDER BY SYOKUGYO_KIND")
	List<Integer> getSyokugyo();
}
