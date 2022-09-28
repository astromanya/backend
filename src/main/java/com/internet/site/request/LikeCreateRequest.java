package com.internet.site.request;

import lombok.Data;

@Data
public class LikeCreateRequest {
    Long id;
    Long userId;
    Long commentId;
}
