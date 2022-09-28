package com.internet.site.responses;

import com.internet.site.entitys.Comment;
import com.internet.site.entitys.Film;
import com.internet.site.entitys.Like;
import lombok.Data;

import java.util.List;

@Data
public class FilmResponse {

    Long id;
    String title;
    String text;


    public FilmResponse(Film entity, List<LikeResponse> likes) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.text = entity.getText();

    }
}