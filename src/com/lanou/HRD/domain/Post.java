package com.lanou.HRD.domain;

/**
 * Created by dllo on 17/10/24.
 */
public class Post {
    private String postId;//主键id
    private String postName;//职务名称

    public Post(String postName) {
        this.postName = postName;
    }

    public Post() {

    }

    public Post(String postId, String postName) {

        this.postId = postId;
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                '}';
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
}
