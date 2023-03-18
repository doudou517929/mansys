package sia.mansys.service;

import sia.mansys.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    User findByCode(String userCode, String password);
    void setCookieValue(HttpServletResponse response, String name, String value, int maxAge);
    static String getCookieValue(HttpServletRequest request, String userCode) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(userCode)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
