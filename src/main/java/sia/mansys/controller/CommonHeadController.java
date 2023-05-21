package sia.mansys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sia.mansys.model.User;
import sia.mansys.service.CommonService;

@Controller
public class CommonHeadController {
	
	@Autowired
	private CommonService commonService;
	
	@GetMapping("/show")
	public String show() {
		return "example";
	}
	
	@ResponseBody
	@GetMapping("/showHead")
	public Map<String, Object> getHead(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		Map<String, Object> result = new HashMap<>();
		result.put("datetime", commonService.getDateTime(user.getUserId()));
        result.put("userName", user.getUserName());
        result.put("role", commonService.getRoleName(user.getUserRole()));
        result.put("tags", commonService.getTags());
        return result;
	}

}
