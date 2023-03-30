package sia.mansys.service;

import java.util.Map;

public interface CommonService {
	String getDateTime(Integer userId);
	String getRoleName(Character userRole);
	Map<String, String> getTags();
}
