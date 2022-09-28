package com.internet.site.services;

import com.internet.site.entitys.Comment;
import com.internet.site.entitys.Like;
import com.internet.site.entitys.User;
import com.internet.site.repos.ILikeRepo;
import com.internet.site.request.LikeCreateRequest;
import com.internet.site.responses.LikeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeService {

    private ILikeRepo iLikeRepo;
    private UserService userService;
    private CommentService commentService;

    public LikeService(ILikeRepo iLikeRepo, UserService userService,
                       CommentService commentService) {
        this.iLikeRepo = iLikeRepo;
        this.userService = userService;
        this.commentService = commentService;
    }

    public List<LikeResponse> getAllLikesWithParam(Optional<Long> userId, Optional<Long> commentId) {
       List<Like> list;
       if(userId.isPresent() && commentId.isPresent()) {
           list = iLikeRepo.findByUserIdAndCommentId(userId.get(), commentId.get());
       }else if(userId.isPresent()) {
           list = iLikeRepo.findByUserId(userId.get());
       }else if(commentId.isPresent()) {
           list = iLikeRepo.findByCommentId(commentId.get());
      }else
           list = iLikeRepo.findAll();
       return list.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());}

    public Like getOneLikeById(Long LikeId) {
        return iLikeRepo.findById(LikeId).orElse(null);
    }

    public Like createOneLike(LikeCreateRequest request) {
       User user = userService.getOneUser(request.getUserId());
        Comment comment = commentService.getOneCommentById(request.getCommentId());
        if(user != null && comment != null) {
            Like likeToSave = new Like();
           likeToSave.setId(request.getId());
           likeToSave.setComment(comment);
          likeToSave.setUser(user);
            return iLikeRepo.save(likeToSave);
        }else
            return null;}

    public void deleteOneLikeById(Long likeId) {
        iLikeRepo.deleteById(likeId);
    }



}