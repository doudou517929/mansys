package sia.mansys.model;

import lombok.Data;

@Data
public class User {
    // USER_ID, USER_CODE, USER_NAME, PASSWORD, USER_ROLE, IS_YOUKOU
	private int userId;
	private String userCode;
	private String userName;
	private String password;
	private char userRole;
	private int isYoukou;
}
