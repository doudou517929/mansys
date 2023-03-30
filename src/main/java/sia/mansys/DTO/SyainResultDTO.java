package sia.mansys.DTO;


import java.util.Date;

import lombok.Data;

@Data
public class SyainResultDTO {
	private int syainId;
	private int syozokuKaisya; // SYOZOKU_KAISYA
	private String firstNameKanji; // FIRST_NAME_KANJI
	private String lastNameKanji; // LAST_NAME_KANJI
	private int seibetu; // SEIBETU
	private int syokugyoKind; // SYOKUGYO_KIND
	private Date nyuusyaDate; // NYUUSYA_DATE
	private Date taisyaDate; // TAISYA_DATE
}
