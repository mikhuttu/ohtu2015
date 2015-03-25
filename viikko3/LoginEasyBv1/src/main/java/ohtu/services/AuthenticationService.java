package ohtu.services;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    private UserDao userDao;

    @Autowired
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        return usernameInvalid(username) || usernameTaken(username) || passwordInvalid(password);
    }

    private boolean usernameInvalid(String username) {
        if (username.length() >= 3) {
            for (char c : username.toCharArray()) {
                
                if (c < 97 || c > 122) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private boolean passwordInvalid(String password) {
        if (password.length() >= 8) {
            for (char c : password.toCharArray()) {
                
                if (c < 65 || c > 122) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean usernameTaken(String username) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
