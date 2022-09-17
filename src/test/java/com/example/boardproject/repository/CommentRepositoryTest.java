package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import com.example.boardproject.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void uploadComment() {
        Board b1 = Board.builder().bId(1).build();
        IntStream.rangeClosed(1,7).forEach(i->{
            Comment comment = Comment.builder().cContent("testComment..." + i).cWriter("tester " + i).cPw("test"+i).board(b1).build();
            System.out.println(commentRepository.save(comment));
        });
    }

    @Test
    void updateComment(){
        int id = 2;
        Comment comment = Comment.builder().cContent("testUpdate...").cId(id).build();
        System.out.println(commentRepository.save(comment));
    }

//    @Test
//    void deleteOneComment(){
//        commentRepository.deleteById(1L);
//    }

    @Test
    void selectone(){
        System.out.println(commentRepository.showCommentList(1));
    }

    @Test
    void deleteAllComment(){
        commentRepository.deleteAll();
    }
}