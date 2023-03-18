package sia.mansys.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserAccessLog {
    private int ID;
    private int USER_ID;
    private String GAMEN_ID;
    private Date START_TIME;
}
