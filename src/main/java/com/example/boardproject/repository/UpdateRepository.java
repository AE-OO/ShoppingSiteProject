package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateRepository extends JpaRepository<Board, Integer> {
}
