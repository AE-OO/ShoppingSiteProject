package com.example.boardproject.repository;

import com.example.boardproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "select c from Comment c where c.board.bId= :bid")
    List<Comment> showCommentList(@Param("bid") int bid);

    @Modifying
    @Transactional
    @Query(value = "insert into Comment(cContent,cDate,cWriter,cPw,bId) values(?1,now(),?2,?3,?4)", nativeQuery = true)
    int uploadComment(@Param("cContent") String cContent, @Param("cWriter") String cWriter, @Param("cPw") String cPw, @Param("bId") int bId);

    @Modifying
    @Transactional
    @Query(value = "update comment set cContent = ?1 where cId = ?2", nativeQuery = true)
    int updateComment(@Param("cContent") String cContent, @Param("cId") int cId);
}
