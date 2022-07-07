package by.itclass.model.db;

public final class SQLRequest {
    public static final String SELECT_USER_BY_LOGIN_AND_PASSWORD =
            "select * from users where login=? and password=?";

    public static final String INSERT_USER_DATA =
            "insert into users(login, password, email) values(?,?,?)";

    public static final String UPDATE_USER_DATA =
            "update users set login=?, email=? where id=?";

    public static final String INSERT_NEWS_DATA =
            "insert into news(title, text, date, time, image, idUser) " +
                    "values(?,?,curdate(),curtime(),?,?)";

    public static final String UPDATE_NEWS_DATA =
            "update news set title=?, text=?, date=curdate(), time=curtime(), image=? where id=?";

    public static final String SELECT_NEWS_DATA_BY_ID =
            "select * from news where id=?";

    public static final String SELECT_NEWS_DATA =
            "select * from news ";

    public static final String WHERE_ALL_NEWS =
            "";

    public static final String WHERE_MY_NEWS =
            "where idUser=? ";

    public static final String REMOVE_NEWS_DATA =
            "delete from news where id=? and idUser=?";

    public static final String ORDER_BY_DATE_AND_TIME =
            "order by date desc, time desc";

}
