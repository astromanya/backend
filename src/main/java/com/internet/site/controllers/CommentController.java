package com.internet.site.controllers;

import com.internet.site.entitys.Comment;
import com.internet.site.request.commentCreateRequest;
import com.internet.site.request.commentUpdateRequest;
import com.internet.site.responses.CommentResponse;
import com.internet.site.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping
    public List<CommentResponse> getAllComments(@RequestParam Optional<Long> userId) {
        return commentService.getAllComments(userId);}

   @PostMapping
   public Comment createOneComment(@RequestBody commentCreateRequest newCommentRequest) {
       return commentService.createOneComment(newCommentRequest);}


    @GetMapping("/{commentId}")
    public CommentResponse getOneComment(@PathVariable Long commentId) {
       return commentService.getOneCommentByIdWithLikes(commentId);}

    @PutMapping("/{commentId}")
    public Comment updateOneComment(
            @PathVariable Long commentId, @RequestBody commentUpdateRequest updateComment) {
       return commentService.updateOneCommentById(commentId, updateComment);}

    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId) {
        commentService.deleteOneComment(commentId);
    }
}

