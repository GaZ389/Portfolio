package by.itclass.model.db.enums;

import by.itclass.model.db.SQLRequest;

public enum NewsListMode {
    ALL_NEWS(SQLRequest.WHERE_ALL_NEWS),
    MY_NEWS(SQLRequest.WHERE_MY_NEWS);

    private String sqlQuery;

    NewsListMode(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public String getSqlQuery() {
        return SQLRequest.SELECT_NEWS_DATA + sqlQuery + SQLRequest.ORDER_BY_DATE_AND_TIME;
    }
}
