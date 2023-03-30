package sia.mansys.service;

import sia.mansys.model.User;

public interface UserService {
    User findByCode(String userCode, String password);
}
