package by.itclass.model.entities;

import java.sql.Date;
import java.sql.Time;

public class News {
    private int id;
    private int idUser;
    private String title;
    private String text;
    private TypeNews type;
    private Date date;
    private Time time;
    private String image;

    public News() {
    }

    public News(int idUser, String id, String title, String text, String image) {
        if (id != null) {
            this.id = Integer.parseInt(id);
        }
        this.idUser = idUser;
        this.title = title;
        this.text = text;
        this.image = image;
    }

    public News(int id, int idUser, String title, String text, String type, Date date, Time time, String image) {
        this.id = id;
        this.idUser = idUser;
        this.title = title;
        this.text = text;
        //this.type = TypeNews.valueOf(type.toUpperCase());
        this.date = date;
        this.time = time;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public TypeNews getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getImage() {
        return image;
    }
}
