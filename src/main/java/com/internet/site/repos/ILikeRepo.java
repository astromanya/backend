package com.internet.site.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internet.site.entitys.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILikeRepo extends JpaRepository<Like, Long> {
    List<Like> findByUserIdAndCommentId(Long userId, Long commentId);

    List<Like> findByUserId(Long userId);

    List<Like> findByCommentId(Long commentId);

    @Query(value = 	"select 'liked', l.comment_id, u.user_name from "
            + "p_like l left join user u on u.id = l.user_id "
            + "where l.comment_id in :commentIds limit 5", nativeQuery = true)
    List<Object> findUserLikesByCommentId(@Param("commentIds") List<Long> commentIds);
}
