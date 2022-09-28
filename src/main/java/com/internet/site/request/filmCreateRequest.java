package com.internet.site.request;

import lombok.Data;

@Data
public class filmCreateRequest {

    Long id;
    String text;
    String title;
    public Byte[] Film_Pic;
}
