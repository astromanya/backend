package com.internet.site.responses;

import com.internet.site.entitys.Like;
import lombok.Data;

@Data
public class LikeResponse {

    Long id;
    Long userId;
    Long commentId;

    public LikeResponse(Like entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.commentId = entity.getComment().getId();
    }
}