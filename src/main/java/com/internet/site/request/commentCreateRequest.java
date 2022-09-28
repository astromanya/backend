package com.internet.site.request;


import lombok.Data;

@Data
public class commentCreateRequest {

    Long id;
    String text;
    String title;
    Long userId;
}