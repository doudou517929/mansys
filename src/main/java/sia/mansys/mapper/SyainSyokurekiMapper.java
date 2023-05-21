package sia.mansys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import sia.mansys.model.SyainSyokureki;

@Mapper
public interface SyainSyokurekiMapper {

	@Insert("INSERT INTO syain_syokureki (SYAIN_ID, NYUSYA, TAISYA, KAISYA, BUSYO) " +
            "VALUES (#{syainId}, #{nyusya}, #{taisya}, #{kaisya}, #{busyo})")
    void insertSyainSyokureki(SyainSyokureki syainSyokureki);
	
	@Select("SELECT * FROM syain_syokureki WHERE SYAIN_ID=#{syainId}")
	List<SyainSyokureki> getSyainSyokurekis(Integer syainId);
	
	@Update("UPDATE syain_syokureki SET NYUSYA = #{nyusya}, TAISYA = #{taisya}, KAISYA = #{kaisya}, BUSYO = #{busyo} " +
	        "WHERE SYAIN_ID = #{syainId}")
	void updateSyainSyokureki(SyainSyokureki syainSyokureki);
}
