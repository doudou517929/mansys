package sia.mansys.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import sia.mansys.mapper.UserAccessLogMapper;
import sia.mansys.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private UserAccessLogMapper userAccessLogMapper;
	
	@Override
	public String getDateTime(Integer userId) {
		Date date = userAccessLogMapper.getDate(userId);
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        String formatTime = "登録日時：" + year + "年" + month + "月" + day + "日  " + hour + "時" + minute + "分" + second + "秒";
		return formatTime;
	}

	@Override
	public String getRoleName(Character userRole) {
		String roleName = "";
		try {
			ClassPathResource resource = new ClassPathResource("/static/data/rolename.json");
	        InputStream inputStream = resource.getInputStream();
			ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode jsonNode = objectMapper.readTree(inputStream);
	        JsonNode roleNode = jsonNode.get(userRole.toString());
	        roleName = roleNode.asText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roleName;
	}

	@Override
	public Map<String, String> getTags() {
		Map<String, String> tags = new LinkedHashMap<>();
		try {
			ClassPathResource resource = new ClassPathResource("/static/data/tags.json");
	        InputStream inputStream = resource.getInputStream();
			ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode jsonNode = objectMapper.readTree(inputStream);
	        if (jsonNode.isArray()) {
	        	jsonNode.forEach(tag -> {
	        		String name = tag.get("name").asText();
	        		String url = tag.get("url").asText();
	        		tags.put(name, url);
	        	});
	        }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
		return tags;
	}

}
