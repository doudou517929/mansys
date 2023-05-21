package sia.mansys.DTO;

import lombok.Data;

@Data
public class SearchSyainDTO {
	// SYOZOKU_KAISYA, kanjiname, SYOKUGYO_KIND, TAISYA_DATE
	private int syozokuKaisya;
	private String nameKanji;
	private Integer syokugyoKind;
	private Integer zaisya;
	private Integer taisya;
}
