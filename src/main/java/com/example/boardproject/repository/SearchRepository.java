package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import com.example.boardproject.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchRepository extends JpaRepository<Board, Integer> {

    @Query("select b from Board b where b.pId.pId = :pId")
    Page<Board> findByPId(int pId, Pageable pageable);

    @Query("select p from Product p ")
    List<Product> productList();
}
