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
			syain.put("所属会社", tgSettingMapper.getV1ByC1C2C3(TgVaule.KaisyaC1.getVal(), syainMain.getSyozokuKaisya(), TgVaule.KaisyaC3.getVal()));
			syain.put("社員名", syainMain.getFirstNameKanji()+syainMain.getLastNameKanji());
			syain.put("性別", Integer.toString(syainMain.getSeibetu()));
			syain.put("職業種類", tgSettingMapper.getV1ByC1C2C3(TgVaule.SyokugyoC1.getVal(), TgVaule.SyokugyoC2.getVal(), syainMain.getSyokugyoKind()));
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
}
