package sia.mansys.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sia.mansys.common.MD5PasswordEncoder;
import sia.mansys.exception.CustomException;
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

    @Override
    public User findByCode(String userCode, String password) {
        User user = userMapper.findByCode(userCode);
//        DBエラー
        if (user == null) {
            throw new CustomException("該当ユーザーが存在しません。");
        }
//        パスワード(MD5で暗号化した内容)
        if (user != null && !passwordEncoder.matches(password, user.getPassword())) {
            throw new CustomException("パスワードが間違っています。");
        }
//        DBの登録履歴に以下の情報を記入
        UserAccessLog userAccessLog = new UserAccessLog();
        userAccessLog.setUserId(user.getUserId());
        userAccessLog.setGamenId("login.jsp");
        userAccessLog.setStartTime(new Date());
        userAccessLogMapper.insertUserAccessLog(userAccessLog);
        return user;
    }
}

