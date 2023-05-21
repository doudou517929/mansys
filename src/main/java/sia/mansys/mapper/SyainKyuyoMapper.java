package sia.mansys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import sia.mansys.model.SyainKyuyo;

/*
 * 社員_給与
 */
@Mapper
public interface SyainKyuyoMapper {

	@Insert("INSERT INTO SYAIN_KYUYO (SYAIN_ID, KAISHI_NENGETSU, SYURYO_NENGETSU, "
			+ "KIHONKYU, SYOKUNOUKYU, KOYOU_HOKEN_NO, NANKIN_NO, NANKIN_KIJYUN_GAKU, "
			+ "KENKOU_HOKEN_NO, BIKOU, TOUROKUBI, KOUSINNBI) " +
            "VALUES (#{syainId}, #{kaishiNengetsu}, #{syuryoNengetsu}, #{kihonkyu}, "
            + "#{syokunoukyu}, #{koyouHokenNo}, #{nankinNo}, #{nankinKijyunGaku}, "
            + "#{kenkouHokenNo}, #{bikou}, #{tourokuBi}, #{koushinBi})")
	void insertSyainKyuyo(SyainKyuyo syainKyuyo);
	
	@Select("SELECT * FROM SYAIN_KYUYO WHERE SYAIN_ID = #{syainId}")
	List<SyainKyuyo> getSyainKyuyos(Integer syainId);
	
	@Update("UPDATE SYAIN_KYUYO SET KAISHI_NENGETSU = #{kaishiNengetsu}, " +
	        "SYURYO_NENGETSU = #{syuryoNengetsu}, " +
	        "KIHONKYU = #{kihonkyu}, " +
	        "SYOKUNOUKYU = #{syokunoukyu}, " +
	        "KOUYOU_HOKEN_NO = #{koyouHokenNo}, " +
	        "NANKIN_NO = #{nankinNo}, " +
	        "NANKIN_KIJYUN_GAKU = #{nankinKijyunGaku}, " +
	        "KENKOU_HOKEN_NO = #{kenkouHokenNo}, " +
	        "BIKOU = #{bikou}, " +
	        "TOUROKUBI = #{tourokuBi}, " +
	        "KOUSINNBI = #{koushinBi} " +
	        "WHERE ID = #{syainId}")
	void updateSyainKyuyo(SyainKyuyo syainKyuyo);
}
