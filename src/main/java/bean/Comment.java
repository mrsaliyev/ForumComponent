package bean;

import java.io.Serializable;

public class Comment implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer postId;
    private String text;
    private Integer cntLike;

    public Comment() {
    }



    public Comment(Integer id, Integer userId, Integer postId, String text, Integer cntLike) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
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

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCntLike() {
        return cntLike;
    }

    public void setCntLike(Integer cntLike) {
        this.cntLike = cntLike;
    }
}
