package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.db.enums.NewsAction;
import by.itclass.model.entities.News;
import by.itclass.model.db.enums.NewsListMode;

import static by.itclass.model.db.SQLRequest.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {

    public News getById(int idNews) {
        News news = null;

        String sqlRequest = NewsAction.VIEW_BY_ID.getSqlRequest();

        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(sqlRequest)) {
            pst.setInt(1, idNews);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                int idUser = rs.getInt("idUser");
                String title = rs.getString("title");
                String text = rs.getString("text");
                String type = rs.getString("type");
                Date date = rs.getDate("date");
                Time time = rs.getTime("time");
                String image = rs.getString("image");
                news = new News(id, idUser, title, text, type, date, time, image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    public List<News> getAll(NewsListMode newsListMode, String sqlParam) {
        List<News> newsList = new ArrayList<>();
        String sqlQuery = newsListMode.getSqlQuery();

        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(sqlQuery)) {

            System.out.println(sqlQuery);
            if (newsListMode == NewsListMode.MY_NEWS) {
                pst.setString(1, sqlParam);
            }
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int idUser = rs.getInt("idUser");
                String title = rs.getString("title");
                String text = rs.getString("text");
                String type = rs.getString("type");
                Date date = rs.getDate("date");
                Time time = rs.getTime("time");
                String image = rs.getString("image");
                newsList.add(new News(id, idUser, title, text, type, date, time, image));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    public boolean save(News news, NewsAction action) {
        boolean isSave = false;
        String sqlRequest = action.getSqlRequest();

        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(sqlRequest)) {
            pst.setString(1, news.getTitle());
            pst.setString(2, news.getText());
            pst.setString(3, news.getImage());

            if (action == NewsAction.ADD) {
                pst.setInt(4, news.getIdUser());
            } else if (action == NewsAction.REFACTOR) {
                pst.setInt(4, news.getId());
            }

            isSave = pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSave;
    }

    public boolean removeById(int idUser, int idNews) {
        boolean isRemove = false;
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(REMOVE_NEWS_DATA)) {

            pst.setInt(1, idNews);
            pst.setInt(2, idUser);

            isRemove = pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRemove;
    }
}
