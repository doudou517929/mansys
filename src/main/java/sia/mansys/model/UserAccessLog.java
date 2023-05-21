package sia.mansys.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserAccessLog {
	private int id;
	private int userId;
	private String gamenId;
	private Date startTime;
}
