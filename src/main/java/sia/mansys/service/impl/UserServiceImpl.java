package sia.mansys.service.impl;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sia.mansys.common.CurrentDateTime;
import sia.mansys.common.MD5PasswordEncoder;
import sia.mansys.exception.PasswordNotMatchException;
import sia.mansys.exception.UserNotFoundException;
import sia.mansys.mapper.UserAccessLogMapper;
import sia.mansys.mapper.UserMapper;
import sia.mansys.model.User;
import sia.mansys.model.UserAccessLog;
import sia.mansys.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAccessLogMapper userAccessLogMapper;

    @Autowired
    private MD5PasswordEncoder passwordEncoder;
    @Autowired
    private CurrentDateTime currentDateTime;

    @Override
    public User findByCode(String userCode, String password) {
        User user = userMapper.findByCode(userCode);
        if (user == null) {
            throw new UserNotFoundException("該当ユーザーが存在しません。");
        }
        if (user != null && !passwordEncoder.matches(password, user.getPassword())) {
            throw new PasswordNotMatchException("パスワードが間違っています。");
        }
        UserAccessLog userAccessLog = new UserAccessLog();
        userAccessLog.setUSER_ID(user.getUSER_ID());
        userAccessLog.setGAMEN_ID("login.jsp");
        userAccessLog.setSTART_TIME(new Date());
        userAccessLogMapper.insertUserAccessLog(userAccessLog);
        return user;
    }

    @Override
    public void setCookieValue(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}

