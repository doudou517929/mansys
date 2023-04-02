package sia.mansys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sia.mansys.DTO.SearchSyainDTO;
import sia.mansys.mapper.SyainMapper;
import sia.mansys.mapper.TgSettingMapper;
import sia.mansys.service.SyainService;
import sia.mansys.service.SyainService.TgVaule;

@Controller
@RequestMapping("/syain")
public class SyainController {
	@Autowired
	private SyainService syainService;
	@Autowired
	private TgSettingMapper tgSettingMapper;
	@Autowired
	private SyainMapper syainMapper;
	
	@GetMapping("/main")
	public String searchPage(Model model) {
		model.addAttribute("searchSyainDTO", new SearchSyainDTO());
		return "syain";
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<Map<String, String>>> searchSyain(@ModelAttribute("searchSyainDTO") SearchSyainDTO searchSyainDTO) {
		return ResponseEntity.ok(syainService.searchSyain(searchSyainDTO));
	}
	
	@GetMapping("/show")
	public ResponseEntity<Map<String, Object>> showSelect() {
		Map<String, Object> body = new HashMap<>();
		body.put("kaisya", tgSettingMapper.getC2sV1sByC1C3(TgVaule.KaisyaC1.getVal(), TgVaule.KaisyaC3.getVal()));
		body.put("syokugyo", tgSettingMapper.getC3sV1sByC1C2(TgVaule.SyokugyoC1.getVal(), TgVaule.SyokugyoC2.getVal()));
		body.put("syainTables", syainService.searchSyain(new SearchSyainDTO()));
		return ResponseEntity.ok(body);
	}
	
	@GetMapping("/upload/syain")
	public String addSyain(Model model) {
		return "addSyain";
	}
	
	@GetMapping("/upload/rirekisyo")
	public String uploadRirekisyo(@RequestParam("id") int id) {
		return "rirekisyo";
	}
	
	@GetMapping("/delete/syain")
	public ResponseEntity<List<Map<String, String>>> deleteSyain(@RequestParam("id") int id) {
		syainMapper.deleteSyain(id, new Date());
		return ResponseEntity.ok(syainService.searchSyain(new SearchSyainDTO()));
	}
	
	@GetMapping("/update/syain")
	public String updateSyain(@RequestParam("id") int id) {
		return "addSyain";
	}
}
