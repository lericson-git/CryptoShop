package test.connect.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int userId;
    private int id;
    private String title;
    private int price;
    @SerializedName("body")
    private String bigText;

    public Post() {}
    public Post(String text) {
        title = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBigText() {
        return bigText;
    }

    public void setBigText(String bigText) {
        this.bigText = bigText;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

