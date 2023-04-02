package sia.mansys.service;

import java.util.List;
import java.util.Map;

import sia.mansys.DTO.SearchSyainDTO;

public interface SyainService {
	public enum TgVaule {
		KaisyaC1(1),
		KaisyaC3(1),
		SyokugyoC1(3),
		SyokugyoC2(4);
		
		private int val;
		
		TgVaule(int val) {
			this.val = val;
		}
		
		public int getVal() {
			return val;
		}
	}
	List<Map<String, String>> searchSyain(SearchSyainDTO searchCondition);
	
}
