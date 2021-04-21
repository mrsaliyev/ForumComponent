package bean;

import java.io.Serializable;

public class Post implements Serializable {
    private Integer id;
    private Integer userId;
    private String title;
    private String text;
    private Integer cntLike;

    public Post() {
    }

    public Post(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Post(Integer id, Integer userId, String title, String text, Integer cntLike) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.text = text;
        this.cntLike = cntLike;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCntLike() {
        return cntLike;
    }

    public void setCntLike(Integer cntLike) {
        this.cntLike = cntLike;
    }
}
