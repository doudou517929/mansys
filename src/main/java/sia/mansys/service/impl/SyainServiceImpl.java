package sia.mansys.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sia.mansys.DTO.SearchSyainDTO;
import sia.mansys.DTO.SyainResultDTO;
import sia.mansys.mapper.SyainMapper;
import sia.mansys.mapper.TgSettingMapper;
import sia.mansys.service.SyainService;

@Service
public class SyainServiceImpl implements SyainService{
	@Autowired
	private SyainMapper syainMapper;
	
	@Autowired
	private TgSettingMapper tgSettingMapper;
	

	@Override
	public List<Map<String, String>> searchSyain(SearchSyainDTO searchCondition) {
		List<Map<String, String>> syains = new LinkedList<>();
		List<SyainResultDTO> syainMains = syainMapper.searchSyain(searchCondition);
		for (Iterator<SyainResultDTO> iterator = syainMains.iterator(); iterator.hasNext();) {
			SyainResultDTO syainMain = (SyainResultDTO) iterator.next();
			Map<String, String> syain = new LinkedHashMap<>();
			syain.put("syainId", Integer.toString(syainMain.getSyainId()));
			syain.put("所属会社", tgSettingMapper.getV2ByC1C2C3(TgVaule.KaisyaC1.getVal(), searchCondition.getSyozoku_kaisya(), TgVaule.KaisyaC3.getVal()));
			syain.put("社員名", syainMain.getFirstNameKanji()+syainMain.getLastNameKanji());
			syain.put("性別", Integer.toString(syainMain.getSeibetu()));
			syain.put("職業種類", tgSettingMapper.getV1ByC1C2C3(TgVaule.SyokugyoC1.getVal(), TgVaule.SyokugyoC2.getVal(), searchCondition.getSyokugyo_kind()));
			syain.put("入社日", convertDate(syainMain.getNyuusyaDate()));
			syain.put("退社日", convertDate(syainMain.getTaisyaDate()));
			syains.add(syain);
		}
		return syains;
	}
	
	private String convertDate(Date date) {
		if (date == null) {
			return "";
		}
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String formatTime = year + "年" + month + "月" + day + "日";
		return formatTime;
	}

	@Override
	public void getPreValue(Map<String, Object> body) {
//		List<Integer> kaisyaIds = syainMapper.getKaisya();
//		List<Map<Integer, String>> kaisyaMap = new LinkedList<>();
//		if (kaisyaIds.size() != 0) {
//			kaisyaMap = tgSettingMapper.getC2V1ByC1C2sC3(TgVaule.KaisyaC1.getVal(), kaisyaIds, TgVaule.KaisyaC3.getVal());
//		}
		body.put("kaisya", tgSettingMapper.getC2sV1sByC1C3(TgVaule.KaisyaC1.getVal(), TgVaule.KaisyaC3.getVal()));
//		List<Integer> syokugyos = syainMapper.getSyokugyo();
//		List<Map<Integer, String>> syokugyoMap = new LinkedList<>();
//		if (syokugyos.size() != 0) {
//			syokugyoMap = tgSettingMapper.getC3sV1sByC1C2C3s(TgVaule.SyokugyoC1.getVal(), TgVaule.SyokugyoC2.getVal(), syokugyos);
//		}
		body.put("syokugyo", tgSettingMapper.getC3sV1sByC1C2(TgVaule.SyokugyoC1.getVal(), TgVaule.SyokugyoC2.getVal()));
		List<Map<String, String>> syains = searchSyain(new SearchSyainDTO());
		body.put("syainTables", syains);
		body.put("cnt", syains.size());
	}
	

}
