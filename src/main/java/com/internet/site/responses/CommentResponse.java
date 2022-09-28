package com.internet.site.responses;

import java.util.List;

import com.internet.site.entitys.Comment;
import com.internet.site.entitys.Like;


import lombok.Data;

@Data
public class CommentResponse {

    Long id;
    Long userId;
    String userName;
    String title;
    String text;
    List<LikeResponse> commentLikes;

    public CommentResponse(Comment entity, List<LikeResponse> likes) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.title = entity.getTitle();
        this.text = entity.getText();
        this.commentLikes = likes;
    }
}
