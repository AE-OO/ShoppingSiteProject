package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@Transactional
class ShowRepositoryTest {

    @Autowired public ShowRepository showRepository;

    /* 후기 상세 보기 */
    @Test
    public void getOneBoard() {
        Board result = showRepository.findByBId(1).get();
        System.out.println(result);
    }

}