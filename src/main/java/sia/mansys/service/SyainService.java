package sia.mansys.service;

import java.util.List;
import java.util.Map;

import sia.mansys.DTO.AddSyainDTO;
import sia.mansys.DTO.SearchSyainDTO;

public interface SyainService {
	public enum TgVaule {
		KaisyaC1(1),
		KaisyaC3(1),
		SyokugyoC1(3),
		SyokugyoC2(4),
		KokusekiC1(3),
		KokusekiC2(1),
		VisaKikanC1(3),
		VisaKikanC2(2),
		ZairyuShikakuC1(3),
		ZairyuShikakuC2(3),
		SaisyuuGakurekiC1(3),
		SaisyuuGakurekiC2(5),
		OSC1(3),
		OSC2(6),
		GengoC1(3),
		GengoC2(7),
		DBC1(3),
		DBC2(8),
		WebServerC1(3),
		WebServerC2(9),
		FWC1(3),
		FWC2(10),
		OtherC1(3),
		OtherC2(11),
		BasyoC1(3),
		BasyoC2(1),
		GyosyuC1(3),
		GyosyuC2(12),
		KaihatuKankyoC1(3),
		KaihatuKankyoC2(6),
		UnyouKankyoC1(3),
		UnyouKankyoC2(6);
		
		private int val;
		
		TgVaule(int val) {
			this.val = val;
		}
		
		public int getVal() {
			return val;
		}
	}
	List<Map<String, String>> searchSyain(SearchSyainDTO searchCondition);
	void insertSyain(AddSyainDTO newSyain);
	AddSyainDTO getSyain(Integer syainId);
	void updateSyain(AddSyainDTO syain);
}
