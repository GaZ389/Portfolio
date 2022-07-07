package by.itclass.model.services;

import by.itclass.model.dao.UserDAO;
import by.itclass.model.entities.User;

import java.sql.SQLException;
import java.util.Map;

public class UserService {
    private UserDAO dao;

    public UserService() {
        dao = new UserDAO();
    }

    public void edit(User user, String login, String email) {
        User tempUser = new User(user.getId(), login, email);
        if (dao.save(tempUser)) {
            user.setLogin(login);
            user.setEmail(email);
        }
    }

    public boolean registration(String login, String password, String email) {
        User user = new User(login, email);
        return dao.save(user, password);
    }

    public User authorization(String login, String password) {
        User user = new User(login);
        if (!dao.get(user, password)) {//true - найден в БД; false - нет такого пользователя
            user = null;
        }
        return user;
    }

}
