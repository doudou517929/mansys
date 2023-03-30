package sia.mansys.DTO;

import lombok.Data;

@Data
public class SearchSyainDTO {
	// SYOZOKU_KAISYA, kanjiname, SYOKUGYO_KIND, TAISYA_DATE
	private Integer syozoku_kaisya;
	private String nameKanji;
	private Integer syokugyo_kind;
	private Integer ZAISYA;
	private Integer TAISYA;
}
