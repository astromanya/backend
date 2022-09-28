package com.internet.site.responses;

import com.internet.site.entitys.User;
import lombok.Data;

@Data
public class UserResponse {

    Long id;
    String userName;

    public UserResponse(User entity) {
        this.id = entity.getId();
        this.userName = entity.getUserName();
    }
}