package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import com.example.boardproject.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchRepository extends JpaRepository<Board, Integer> {

    @Query("select b from Board b where b.pId.pId = :pId")
    Page<Board> findByPId(int pId, Pageable pageable);

    @Query("select p from Product p ")
    List<Product> productList();

//    0919 ho 추가 - 검색기능 메서드(이중 셀렉트문)
    @Query(value = "select * from( select * from Board where bTitle like %:keyword%) a where pId=:pId", nativeQuery = true)
    Page<Board> searchMethod(String keyword, int pId, Pageable pageable);

}
