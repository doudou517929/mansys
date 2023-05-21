package sia.mansys.service.impl;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sia.mansys.DTO.AddSyainDTO;
import sia.mansys.DTO.SearchSyainDTO;
import sia.mansys.DTO.SyainResultDTO;
import sia.mansys.mapper.SyainKyuyoMapper;
import sia.mansys.mapper.SyainMapper;
import sia.mansys.mapper.SyainRirekiMapper;
import sia.mansys.mapper.SyainSyokurekiMapper;
import sia.mansys.mapper.TgSettingMapper;
import sia.mansys.model.SyainKyuyo;
import sia.mansys.model.SyainMain;
import sia.mansys.model.SyainRireki;
import sia.mansys.model.SyainSyokureki;
import sia.mansys.service.SyainService;

@Service
public class SyainServiceImpl implements SyainService{
	@Autowired
	private SyainMapper syainMapper;
	@Autowired
	private SyainKyuyoMapper syainKyuyoMapper;
	@Autowired
	private TgSettingMapper tgSettingMapper;
	@Autowired
	private SyainSyokurekiMapper syainSyokurekiMapper;
	@Autowired
	private SyainRirekiMapper syainRirekiMapper;
	
	/**
	 * 検索条件により、検索し、結果を表示する
	 */
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
			String seibetu = syainMain.getSeibetu() == 0 ? "女" : "男";
			syain.put("性別", seibetu);
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

	@Override
	public void insertSyain(AddSyainDTO newSyain) {
		SyainMain syainMain = newSyain.getSyainMain();
		syainMain.setTourokubi(new Date());
		syainMapper.insertSyainMain(syainMain);
		Integer syainId = syainMapper.getSyainId(syainMain.getEmployeeCode());
		List<SyainSyokureki> syainSyokurekis = newSyain.getSyainSyokurekis();
		if (syainSyokurekis != null) {
			for (SyainSyokureki syokureki : syainSyokurekis) {
				if (syokureki == null) {
					break;
				}
				syokureki.setSyainId(syainId);
				syainSyokurekiMapper.insertSyainSyokureki(syokureki);
			}
		}
		List<SyainKyuyo> syainKyuyo = newSyain.getSyainKyuyo();
		if (syainKyuyo != null) {
			for (SyainKyuyo kyuyo : syainKyuyo) {
				if (kyuyo == null) {
					break;
				}
				kyuyo.setSyainId(syainId);
				kyuyo.setTourokuBi(LocalDateTime.now());
				syainKyuyoMapper.insertSyainKyuyo(kyuyo);
			}
		}
		List<SyainRireki> syainRireki = newSyain.getSyainRireki();
		if (syainRireki != null) {
			for (SyainRireki rireki : syainRireki) {
				if (rireki == null) {
					break;
				}
				rireki.setSyainId(syainId);
				rireki.setTourokuDate(LocalDateTime.now());
				syainRirekiMapper.insertSyainRireki(rireki);
			}
		}
	}

	@Override
	public AddSyainDTO getSyain(Integer syainId) {
		AddSyainDTO newSyainDTO = new AddSyainDTO();
		newSyainDTO.setSyainRireki(syainRirekiMapper.getSyainRirekiList(syainId));
		newSyainDTO.setSyainKyuyo(syainKyuyoMapper.getSyainKyuyos(syainId));
		newSyainDTO.setSyainSyokurekis(syainSyokurekiMapper.getSyainSyokurekis(syainId));
		newSyainDTO.setSyainMain(syainMapper.getSyainMain(syainId));
		return newSyainDTO;
	}

	@Override
	public void updateSyain(AddSyainDTO syain) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	
	
}
