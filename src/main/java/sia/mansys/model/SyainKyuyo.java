package sia.mansys.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SyainKyuyo {								
//	社員番号
	private int syainId;
//	開始年月
    private String kaishiNengetsu;
//    終了年月
    private String syuryoNengetsu;
//    基本給
    private int kihonkyu;
//    職能給
    private int syokunoukyu;
//    雇用保険番号	
    private String koyouHokenNo;
//    年金番号
    private String nankinNo;
//    年金基準額
    private int nankinKijyunGaku;
//    健康保険番号
    private String kenkouHokenNo;
//    備考
    private String bikou;
//    登録日
    private LocalDateTime tourokuBi;
//    更新日
    private LocalDateTime koushinBi;
}
