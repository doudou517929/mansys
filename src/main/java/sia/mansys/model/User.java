package sia.mansys.model;

import lombok.Data;

@Data
public class User {
    // USER_ID, USER_CODE, USER_NAME, PASSWORD, USER_ROLE, IS_YOUKOU
    private int USER_ID;
    private String USER_CODE;
    private String USER_NAME;
    private String password;
    private char USER_ROLE;
    private int IS_YOUKOU;
}
