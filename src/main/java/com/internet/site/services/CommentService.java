package com.internet.site.services;

import com.internet.site.request.commentCreateRequest;
import com.internet.site.request.commentUpdateRequest;
import com.internet.site.entitys.Comment;
import com.internet.site.entitys.User;
import com.internet.site.repos.ICommentRepo;
import com.internet.site.responses.CommentResponse;
import com.internet.site.responses.LikeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private ICommentRepo iCommentRepo;
    private LikeService likeService;
    private UserService userService;

    public CommentService(ICommentRepo iCommentRepo,
                       UserService userService) {
        this.iCommentRepo = iCommentRepo;
        this.userService = userService;
    }

    @Autowired
    public void setLikeService(@Lazy LikeService likeService) {
        this.likeService = likeService;}
   public List<CommentResponse> getAllComments(Optional<Long> userId) {
       List<Comment> list;
      if(userId.isPresent()) {
          list = iCommentRepo.findByUserId(userId.get());
     }else
          list = iCommentRepo.findAll();
      return list.stream().map(p -> {
          List<LikeResponse> likes = likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(p.getId()));
          return new CommentResponse(p, likes);}).collect(Collectors.toList());
   }

    public Comment getOneCommentById(Long commentId) {
        return iCommentRepo.findById(commentId).orElse(null);
    }

    public CommentResponse getOneCommentByIdWithLikes(Long commentId) {
        Comment comment = iCommentRepo.findById(commentId).orElse(null);
        List<LikeResponse> likes = likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(commentId));
        return new CommentResponse(comment, likes);}

   public Comment createOneComment(commentCreateRequest newCommentRequest) {
        User user = userService.getOneUser(newCommentRequest.getUserId());
        if(user == null)
           return null;
       Comment toSave = new Comment();
        toSave.setId(newCommentRequest.getId());
      toSave.setText(newCommentRequest.getText());
     toSave.setTitle(newCommentRequest.getTitle());
     toSave.setUser(user);
       toSave.setCreateDate(new Date());
      return iCommentRepo.save(toSave);}

    public Comment updateOneCommentById(Long commentId, commentUpdateRequest updateComment) {
        Optional<Comment> comment = iCommentRepo.findById(commentId);
        if(comment.isPresent()) {
           Comment toUpdate = comment.get();
           toUpdate.setText(updateComment.getText());
           toUpdate.setTitle(updateComment.getTitle());
           iCommentRepo.save(toUpdate);
           return toUpdate;
        }
       return null;}

    public void deleteOneComment(Long commentId) {
        iCommentRepo.deleteById(commentId);
    }


}