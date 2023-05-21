package sia.mansys.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import sia.mansys.DTO.AddSyainDTO;
import sia.mansys.DTO.SearchSyainDTO;
import sia.mansys.mapper.SyainMapper;
import sia.mansys.mapper.TgSettingMapper;
import sia.mansys.service.SyainService;
import sia.mansys.service.SyainService.TgVaule;

@Slf4j
@Validated
@Controller
@RequestMapping("/syain")
public class SyainController {
	@Autowired
	private SyainService syainService;
	@Autowired
	private TgSettingMapper tgSettingMapper;
	@Autowired
	private SyainMapper syainMapper;
	
	/**
	 * 社員管理
	 * @param model
	 * @return
	 */
	@GetMapping("/main")
	public String searchPage(Model model) {
		model.addAttribute("searchSyainDTO", new SearchSyainDTO());
		return "syain";
	}
	
	/**
	 * 検索条件により、検索し、結果を表示する
	 * @param searchSyainDTO
	 * @return
	 */
	@PostMapping("/search")
	public ResponseEntity<List<Map<String, String>>> searchSyain(@ModelAttribute("searchSyainDTO") SearchSyainDTO searchSyainDTO) {
		return ResponseEntity.ok(syainService.searchSyain(searchSyainDTO));
	}
	
	/**
	 * 初期表示
	 * @return
	 */
	@GetMapping("/show")
	public ResponseEntity<Map<String, Object>> showSelect() {
		Map<String, Object> body = new HashMap<>();
//		所属会社プルダウンリスト情報の取得
		body.put("kaisya", tgSettingMapper.getC2sV1sByC1C3(TgVaule.KaisyaC1.getVal(), TgVaule.KaisyaC3.getVal()));
//		職業種類プルダウンリスト情報の取得
		body.put("syokugyo", tgSettingMapper.getC3sV1sByC1C2(TgVaule.SyokugyoC1.getVal(), TgVaule.SyokugyoC2.getVal()));
//		初期検索条件のどおり現有データを表示されました。
		body.put("syainTables", syainService.searchSyain(new SearchSyainDTO()));
		return ResponseEntity.ok(body);
	}
	
	/**
	 * 社員登録ページ
	 * @param model
	 * @return
	 */
	@GetMapping("/upload/syain")
	public String addSyain(Model model) {
		model.addAttribute("addSyainDTO", new AddSyainDTO());
		return "syainTouroku";
	}
	
	/**
	 * プルダウンリストの情報を取得し、プルダウンリストにセットする
	 * @return
	 */
	@GetMapping("/load/syainitems")
	public ResponseEntity<Map<String, Object>> returnItems() {
		Map<String, Object> body = new HashMap<>();
		body.put("kokuseki", tgSettingMapper.getC3sV1sByC1C2(TgVaule.KokusekiC1.getVal(), TgVaule.KokusekiC2.getVal()));
		body.put("visaKikan", tgSettingMapper.getC3sV1sByC1C2(TgVaule.VisaKikanC1.getVal(), TgVaule.VisaKikanC2.getVal()));
		body.put("zairyuShikaku", tgSettingMapper.getC3sV1sByC1C2(TgVaule.ZairyuShikakuC1.getVal(), TgVaule.ZairyuShikakuC2.getVal()));
		body.put("syozokuKaisya", tgSettingMapper.getC2sV1sByC1C3(TgVaule.KaisyaC1.getVal(), TgVaule.KaisyaC3.getVal()));
		body.put("syokugyoKind", tgSettingMapper.getC3sV1sByC1C2(TgVaule.SyokugyoC1.getVal(), TgVaule.SyokugyoC2.getVal()));
		body.put("saisyuuGakureki", tgSettingMapper.getC3sV1sByC1C2(TgVaule.SaisyuuGakurekiC1.getVal(), TgVaule.SaisyuuGakurekiC2.getVal()));
		body.put("OS", tgSettingMapper.getC3sV1sByC1C2(TgVaule.OSC1.getVal(), TgVaule.OSC2.getVal()));
		body.put("gengo", tgSettingMapper.getC3sV1sByC1C2(TgVaule.GengoC1.getVal(), TgVaule.GengoC2.getVal()));
		body.put("DB", tgSettingMapper.getC3sV1sByC1C2(TgVaule.DBC1.getVal(), TgVaule.DBC2.getVal()));
		body.put("WebServer", tgSettingMapper.getC3sV1sByC1C2(TgVaule.WebServerC1.getVal(), TgVaule.WebServerC2.getVal()));
		body.put("FW", tgSettingMapper.getC3sV1sByC1C2(TgVaule.FWC1.getVal(), TgVaule.FWC2.getVal()));
		body.put("Other", tgSettingMapper.getC3sV1sByC1C2(TgVaule.OtherC1.getVal(), TgVaule.OtherC2.getVal()));
		return ResponseEntity.ok(body);
	}
	
	/**
	 * 業務経歴
	 * @return
	 */
	@GetMapping("/upload/rireki")
	public ResponseEntity<Map<String, Object>> returnRirekiItems() {
		Map<String, Object> body = new HashMap<>();
		body.put("basyo", tgSettingMapper.getC3sV1sByC1C2(TgVaule.BasyoC1.getVal(), TgVaule.BasyoC2.getVal()));
		body.put("gyosyu", tgSettingMapper.getC3sV1sByC1C2(TgVaule.GyosyuC1.getVal(), TgVaule.GyosyuC2.getVal()));
		body.put("kaihatukankyo", tgSettingMapper.getC3sV1sByC1C2(TgVaule.KaihatuKankyoC1.getVal(), TgVaule.KaihatuKankyoC2.getVal()));
		body.put("unyoukankyo", tgSettingMapper.getC3sV1sByC1C2(TgVaule.UnyouKankyoC1.getVal(), TgVaule.UnyouKankyoC2.getVal()));
		return ResponseEntity.ok(body);
	}
	
	/**
	 * 社員登録
	 * @param addSyainDTO
	 * @param result
	 * @return
	 */
	@PostMapping("/upload/syaininfo")
	public ResponseEntity<Map<String,String>> uploadSyain(@Valid @ModelAttribute("addSyainDTO") AddSyainDTO addSyainDTO, BindingResult result) {
		Map<String,String> body = new HashMap<>();
		if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String field = fieldError.getField();
                String defaultMessage = fieldError.getDefaultMessage();
                body.put(field,defaultMessage);
            }
			return ResponseEntity.badRequest().body(body);
		}
		System.out.println(addSyainDTO);
		syainService.insertSyain(addSyainDTO);
		return ResponseEntity.ok(body);
	}
	
	/**
	 * 職務経歴書登録
	 * @param id
	 * @return
	 */
	@GetMapping("/upload/rirekisyo")
	public String uploadRirekisyo(@RequestParam("id") int id) {
		return "rirekisyo";
	}
	
	/**
	 * DB上で、該当社員基本情報と担当者情報を論理削除する
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/syain")
	public ResponseEntity<List<Map<String, String>>> deleteSyain(@RequestParam("id") int id) {
		syainMapper.deleteSyain(id, new Timestamp(new Date().getTime()));
		return ResponseEntity.ok(syainService.searchSyain(new SearchSyainDTO()));
	}
	
	/**
	 * 社員更新
	 * @param syainId
	 * @param model
	 * @return
	 */
	@GetMapping("/update/syain")
	public String updateSyain(@RequestParam("id") int syainId, Model model) {
		model.addAttribute("addSyainDTO", syainService.getSyain(syainId));
		model.addAttribute("update", true);
		return "syainTouroku";
	}
	
	/**
	 * 社員更新
	 * @param addSyainDTO
	 * @param result
	 * @return
	 */
	@GetMapping("/update/syainData")
	public ResponseEntity<Map<String,String>> updateSyain(@Valid @ModelAttribute("addSyainDTO") AddSyainDTO addSyainDTO, BindingResult result) {
		Map<String,String> body = new HashMap<>();
		if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String field = fieldError.getField();
                String defaultMessage = fieldError.getDefaultMessage();
                body.put(field,defaultMessage);
            }
			return ResponseEntity.badRequest().body(body);
		}
		System.out.println(addSyainDTO);
		syainService.updateSyain(addSyainDTO);
		return ResponseEntity.ok(body);
	}
}
