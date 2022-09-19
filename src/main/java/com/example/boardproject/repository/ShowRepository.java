package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import com.example.boardproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository{

    public Optional<Board> findByBId(int bId);

    public Optional<Product> findByPId(int pId);
}
