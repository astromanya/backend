package com.internet.site.controllers;

import com.internet.site.entitys.Like;
import com.internet.site.request.LikeCreateRequest;
import com.internet.site.responses.LikeResponse;
import com.internet.site.services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

   @GetMapping
   public List<LikeResponse> getAllLikes
           (@RequestParam Optional<Long> userId, @RequestParam Optional<Long> commentId) {
       return likeService.getAllLikesWithParam(userId, commentId);}

   @PostMapping
       public Like createOneLike(@RequestBody LikeCreateRequest request) {
       return likeService.createOneLike(request);}

    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId) {
        return likeService.getOneLikeById(likeId);
    }

    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId) {
        likeService.deleteOneLikeById(likeId);
    }
}
