package sia.mansys.common;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CurrentDateTime {
    public String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        return "登録日時：" + year + "年" + month + "月" + day + "日      " + hour + "時" + minute + "分" + second + "秒";
    }
}
