package com.man;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sia.mansys.ManSysApplication;
import sia.mansys.service.CommonService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManSysApplication.class)
public class EmployeeManageServiceTest {

	@Autowired
	private CommonService commonService;
	
	@Test
	public void testDateTime() {
		String formatTime = commonService.getDateTime(1);
		System.out.println(formatTime);
	}
	@Test
	public void testGetRole() {
		String userRole = commonService.getRoleName('S');
		System.out.println("userRole is: " + userRole);
	}
	@Test
	public void testGetTags() {
		Map<String, String> tags = commonService.getTags();
		System.out.println("打印tags");
		for (Map.Entry<String, String> tag : tags.entrySet()) {
			System.out.println(tag.getKey() + tag.getValue());
		}
	}
}
