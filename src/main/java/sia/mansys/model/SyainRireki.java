package sia.mansys.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SyainRireki {							
//	社員番号
	private int syainId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
//	開始日
    private Date kaisibi;
	@DateTimeFormat(pattern="yyyy-MM-dd")
//	終了日
    private Date syuryobi;
//    private String kaisyaName;
//    private String busyo;
//    登録日
    private LocalDateTime tourokuDate;
//    更新日
    private LocalDateTime koushinDate;
//    プロジェクト名
    private String pjName;
//    対日フラグ
    private Integer tainitiFlag;
//    場所
    private Integer basyo;
//    規模
    private Integer kibo;
//    業種
    private Integer gyosyu;
//    開発環境
    private Integer kaihatukankyo;
//    運用環境
    private Integer unyoukankyo;
//    言語
    private String gengo;
//    DB	
    private String db;
//    ツール	
    private String tool;
//    担当
    private Integer tantou;
//    作業範囲
    private Integer sagyohani;
//    概要
    private String gaiyou;
}
