package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.User;

import static by.itclass.model.db.SQLRequest.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public boolean save(User user) {
        boolean isSave = false;
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(UPDATE_USER_DATA)) {
            pst.setString(1, user.getLogin());
            pst.setString(2, user.getEmail());
            pst.setInt(3, user.getId());

            isSave = pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSave;
    }

    public boolean save(User user, String password) {
        boolean isSave = false;
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(INSERT_USER_DATA)) {
            pst.setString(1, user.getLogin());
            pst.setString(2, password);
            pst.setString(3, user.getEmail());

            isSave = pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSave;
    }

    public boolean get(User user, String password) {
        boolean isGet = false;
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(SELECT_USER_BY_LOGIN_AND_PASSWORD)) {
            pst.setString(1, user.getLogin());
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String image = rs.getString("image");

                user.setId(id);
                user.setEmail(email);
                user.setImage(image);
                isGet = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isGet;
    }


}
