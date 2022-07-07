package by.itclass.model.db.enums;

import by.itclass.model.db.SQLRequest;

public enum NewsAction {
    VIEW_BY_ID(SQLRequest.SELECT_NEWS_DATA_BY_ID),
    ADD(SQLRequest.INSERT_NEWS_DATA),
    REFACTOR(SQLRequest.UPDATE_NEWS_DATA),
    DELETE(SQLRequest.REMOVE_NEWS_DATA);

    private String sqlRequest;

    NewsAction(String sqlRequest) {
        this.sqlRequest = sqlRequest;
    }

    public String getSqlRequest() {
        return sqlRequest;
    }
}
