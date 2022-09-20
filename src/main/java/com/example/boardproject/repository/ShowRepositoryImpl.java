package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import com.example.boardproject.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public class ShowRepositoryImpl implements ShowRepository{

    private final EntityManager em;

    public ShowRepositoryImpl(EntityManager em) {this.em = em;}

    @Override
    public Optional<Board> findByBId(int bId) {
        Board board = em.find(Board.class, bId);
        return Optional.ofNullable(board);
    }

    @Override
    public Optional<Product> findByPId(int pId) {
        Product product = em.find(Product.class, pId);
        return Optional.ofNullable(product);
    }
}
