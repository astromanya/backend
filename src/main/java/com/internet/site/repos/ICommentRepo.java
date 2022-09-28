package com.internet.site.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internet.site.entitys.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findByUserId(Long userId);

    @Query(value = "select id from comment where user_id = :userId order by create_date desc limit 5",
            nativeQuery = true)
    List<Long> findTopByUserId(@Param("userId") Long userId);



}
