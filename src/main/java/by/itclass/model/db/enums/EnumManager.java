package by.itclass.model.db.enums;

public class EnumManager {

    public static NewsAction getKindNewsAction(String action) {
        return NewsAction.valueOf(action.toUpperCase());
    }

}
