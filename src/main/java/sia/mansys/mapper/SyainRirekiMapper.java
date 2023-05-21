package sia.mansys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import sia.mansys.model.SyainRireki;

//社員_履歴
@Mapper
public interface SyainRirekiMapper {

	@Insert("INSERT INTO SYAIN_RIREKI (SYAIN_ID, KAISIBI, SYURYOBI, TOUROKUBI, KOUSINNBI, PJ_NAME, TAINITI_FLAG, BASYO, KIBO, GYOSYU, KAIHATUKANKYO, UNYOUKANKYO, GENGO, DB, TOOL, TANTOU, SAGYOHANI, GAIYOU) " +
	        "VALUES (#{syainId}, #{kaisibi}, #{syuryobi}, #{tourokuDate}, #{koushinDate}, #{pjName}, #{tainitiFlag}, #{basyo}, #{kibo}, #{gyosyu}, #{kaihatukankyo}, #{unyoukankyo}, #{gengo}, #{db}, #{tool}, #{tantou}, #{sagyohani}, #{gaiyou})")
	void insertSyainRireki(SyainRireki syainRireki);
	
	@Select("SELECT * FROM SYAIN_RIREKI WHERE SYAIN_ID = #{syainId}")
	List<SyainRireki> getSyainRirekiList(Integer syainId);

	@Update("UPDATE SYAIN_RIREKI SET KAISIBI = #{kaisibi}, SYURYOBI = #{syuryobi}, " +
	        "TOUROKUBI = #{tourokuDate}, " +
	        "KOUSINNBI = #{koushinDate}, PJ_NAME = #{pjName}, TAINITI_FLAG = #{tainitiFlag}, " +
	        "BASYO = #{basyo}, KIBO = #{kibo}, GYOSYU = #{gyosyu}, KAIHATUKANKYO = #{kaihatukankyo}, " +
	        "UNYOUKANKYO = #{unyoukankyo}, GENGO = #{gengo}, DB = #{db}, TOOL = #{tool}, " +
	        "TANTOU = #{tantou}, SAGYOHANI = #{sagyohani}, GAIYOU = #{gaiyou} " +
	        "WHERE SYAIN_ID = #{syainId}")
	void updateSyainRireki(SyainRireki syainRireki);
}
