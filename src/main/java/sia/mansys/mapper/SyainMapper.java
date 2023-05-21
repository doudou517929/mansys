package sia.mansys.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.MappedTypes;

import sia.mansys.DTO.SearchSyainDTO;
import sia.mansys.DTO.SyainResultDTO;
import sia.mansys.model.SyainMain;

@Mapper
@MappedTypes({SyainMain.class, SyainResultDTO.class})
public interface SyainMapper {

	@Select("SELECT SYAIN_ID,SYOZOKU_KAISYA,FIRST_NAME_KANJI,LAST_NAME_KANJI,SEIBETU,SYOKUGYO_KIND,NYUUSYA_DATE,TAISYA_DATE FROM SYAIN_MAIN "
			+ "WHERE (#{searchSyainDTO.syozokuKaisya} = 0 OR SYOZOKU_KAISYA=#{searchSyainDTO.syozokuKaisya}) "
			+ "AND (#{searchSyainDTO.nameKanji} IS NULL OR #{searchSyainDTO.nameKanji} = '' OR CONCAT(FIRST_NAME_KANJI,LAST_NAME_KANJI) LIKE #{searchSyainDTO.nameKanji}) "
			+ "AND (#{searchSyainDTO.syokugyoKind} IS NULL OR SYOKUGYO_KIND=#{searchSyainDTO.syokugyoKind}) "
			+ "AND (((#{searchSyainDTO.taisya} IS NULL OR TAISYA_DATE IS NOT NULL) "
			+ "AND (#{searchSyainDTO.zaisya} IS NULL OR TAISYA_DATE IS NULL))"
			+ "OR (#{searchSyainDTO.zaisya} IS NOT NULL AND #{searchSyainDTO.taisya} IS NOT NULL)) "
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
	
	/**
	 * DB上で、該当社員基本情報と担当者情報を論理削除する
	 * @param syainId
	 * @param date
	 */
	@Select("UPDATE SYAIN_MAIN SET DELETE_FLAG=1,TAISYA_DATE=#{date} WHERE SYAIN_ID=#{syainId}")
	void deleteSyain(@Param("syainId")int syainId, @Param("date")Date date);
	
	@Insert("INSERT INTO SYAIN_MAIN("
			+ "FIRST_NAME_KANJI, LAST_NAME_KANJI, "
			+ "FIRST_NAME_KANA, LAST_NAME_KANA, " 
			+ "FIRST_NAME_EIGO, LAST_NAME_EIGO, "
	        + "SEIBETU, TANJYOBI, KOKUSEKI, SYUSSINN, HAIGUSYA, "
	        + "PASSPORT_NUM, PASSPORT_END_DATE, VISA_KIKAN, VISA_END_DATE, ZAIRYU_SIKAKU, KOJIN_NUM, ZAIRYU_NUM, "
	        + "SYOZOKU_KAISYA, " +
	        "NYUUSYA_DATE, TAISYA_DATE, SYOKUGYO_KIND, RAINITI_DATE, BIKOU, YUUBIN, JYUSYO_1, JYUSYO_2, MOYORI_EKI, " +
	        "TEL, EMAIL, WECHAT, LINE, BOKOKU_JYUSYO, BOKOKU_KINNKYUU_RENNRAKU, SAISYUU_GAKUREKI, GAKKOU_NAME, SENNMOM_NAME, " +
	        "SOTUGYO_DATE, GYUMU_NENSU, IT_OS, IT_GENGO, IT_DB, IT_WEB_SERVER, IT_FW, IT_OTHER, IT_BIKOU, DELETE_FLAG, " +
	        "TOUROKUBI, KOUSINNBI, EMPLOYEECODE, COMMENT, KINYUKIKAN_CODE, KINYUKIKAN_NAME, SITEN_CODE, SITEN_NAME, KOUZA_KIND, " + 
	        "KOUZA_NUM, MEIGI_NAME) VALUES (#{firstNameKanji}, #{lastNameKanji}, #{firstNameKana}, #{lastNameKana}, " +
	        "#{firstNameEigo}, #{lastNameEigo}, #{seibetu}, #{tanjyobi}, #{kokuseki}, #{syussinn}, #{haigusya}, " +
	        "#{passportNum}, #{passportEndDate}, #{visaKikan}, #{visaEndDate}, #{zairyuSikaku}, #{kojinNum}, " +
	        "#{zairyuNum}, #{syozokuKaisya}, #{nyuusyaDate}, #{taisyaDate}, #{syokugyoKind}, #{rainitiDate}, " +
	        "#{bikou}, #{yuubin}, #{jyusyo1}, #{jyusyo2}, #{moyoriEki}, #{tel}, #{email}, #{wechat}, #{line}, " +
	        "#{bokokuJyusyo}, #{bokokuKinnkyuuRennraku}, #{saisyuuGakureki}, #{gakkouName}, #{sennmomName}, " +
	        "#{sotugyoDate}, #{gyumuNensu}, #{itOs}, #{itGengo}, #{itDb}, #{itWebServer}, #{itFw}, #{itOther}, " +
	        "#{itBikou}, #{deleteFlag}, #{tourokubi}, #{kousinnbi}, #{employeeCode}, #{comment}, #{kinyukikanCode}, " + 
	        "#{kinyukikanName}, #{sitenCode}, #{sitenName}, #{kouzaKind}, #{kouzaNum}, #{meigiName})")
	void insertSyainMain(SyainMain syainMain);
	
	@Select("SELECT * FROM SYAIN_MAIN WHERE SYAIN_ID=#{syainId}")
	SyainMain getSyainMain(Integer syainId);
	
	@Select("SELECT SYAIN_ID FROM SYAIN_MAIN WHERE EMPLOYEECODE=#{employeeCode}")
	Integer getSyainId(String employeeCode);
	
	@Update("UPDATE SYAIN_MAIN SET "
	        + "FIRST_NAME_KANJI = #{firstNameKanji}, LAST_NAME_KANJI = #{lastNameKanji}, "
	        + "FIRST_NAME_KANA = #{firstNameKana}, LAST_NAME_KANA = #{lastNameKana}, "
	        + "FIRST_NAME_EIGO = #{firstNameEigo}, LAST_NAME_EIGO = #{lastNameEigo}, "
	        + "SEIBETU = #{seibetu}, TANJYOBI = #{tanjyobi}, KOKUSEKI = #{kokuseki}, SYUSSINN = #{syussinn}, HAIGUSYA = #{haigusya}, "
	        + "PASSPORT_NUM = #{passportNum}, PASSPORT_END_DATE = #{passportEndDate}, VISA_KIKAN = #{visaKikan}, VISA_END_DATE = #{visaEndDate}, ZAIRYU_SIKAKU = #{zairyuSikaku}, "
	        + "KOJIN_NUM = #{kojinNum}, ZAIRYU_NUM = #{zairyuNum}, SYOZOKU_KAISYA = #{syozokuKaisya}, "
	        + "NYUUSYA_DATE = #{nyuusyaDate}, TAISYA_DATE = #{taisyaDate}, SYOKUGYO_KIND = #{syokugyoKind}, RAINITI_DATE = #{rainitiDate}, "
	        + "BIKOU = #{bikou}, YUUBIN = #{yuubin}, JYUSYO_1 = #{jyusyo1}, JYUSYO_2 = #{jyusyo2}, MOYORI_EKI = #{moyoriEki}, "
	        + "TEL = #{tel}, EMAIL = #{email}, WECHAT = #{wechat}, LINE = #{line}, BOKOKU_JYUSYO = #{bokokuJyusyo}, "
	        + "BOKOKU_KINNKYUU_RENNRAKU = #{bokokuKinnkyuuRennraku}, SAISYUU_GAKUREKI = #{saisyuuGakureki}, "
	        + "GAKKOU_NAME = #{gakkouName}, SENNMOM_NAME = #{sennmomName}, SOTUGYO_DATE = #{sotugyoDate}, "
	        + "GYUMU_NENSU = #{gyumuNensu}, IT_OS = #{itOs}, IT_GENGO = #{itGengo}, IT_DB = #{itDb}, "
	        + "IT_WEB_SERVER = #{itWebServer}, IT_FW = #{itFw}, IT_OTHER = #{itOther}, IT_BIKOU = #{itBikou}, "
	        + "KOUSINNBI = #{kousinnbi}, EMPLOYEECODE = #{employeeCode}, "
	        + "COMMENT = #{comment}, KINYUKIKAN_CODE = #{kinyukikanCode}, KINYUKIKAN_NAME = #{kinyukikanName}, "
	        + "SITEN_CODE = #{sitenCode}, SITEN_NAME = #{sitenName}, KOUZA_KIND = #{kouzaKind}, "
	        + "KOUZA_NUM = #{kouzaNum}, MEIGI_NAME = #{meigiName} "
	        + "WHERE SYAIN_ID = #{syainId}")
	void updateSyainMain(SyainMain syainMain);

}
