package by.itclass.model.services;

import by.itclass.model.dao.NewsDAO;
import by.itclass.model.db.enums.EnumManager;
import by.itclass.model.db.enums.NewsAction;
import by.itclass.model.entities.News;
import by.itclass.model.db.enums.NewsListMode;

import java.util.List;

public class NewsService {
    private NewsDAO dao;

    public NewsService() {
        dao = new NewsDAO();
    }

    public News get(String id) {
        Integer idNews = Integer.parseInt(id);
        return dao.getById(idNews);
    }

    public boolean delete(int idUser, String id) {
        int idNews = Integer.parseInt(id);
        return dao.removeById(idUser, idNews);
    }

    public boolean save(News news, NewsAction action) {
        return dao.save(news, action);
    }

    public List<News> listByMode(NewsListMode newsListMode, String param) {
        return dao.getAll(newsListMode, param);
    }

}
