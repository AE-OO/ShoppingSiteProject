package com.example.boardproject.service;

import com.example.shopping.dto.BoardDTO;
import com.example.shopping.dto.PageRequestDTO;
import com.example.shopping.dto.PageResultDTO;
import com.example.shopping.entity.Board;
import com.example.shopping.repository.SearchRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Log4j2
@Service
public class BoardServiceImpl implements BoardService {

    private final SearchRepository searchRepository;

    @Autowired
    public BoardServiceImpl(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    public PageResultDTO<BoardDTO, Board> getList(int pId,PageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("bId").descending());

        Page<Board> result = searchRepository.findByPId(pId,pageable);

        for(Board  board1: result){
            System.out.println("board1 = " + board1);
        }

        System.out.println("result = " + result);

        Function<Board, BoardDTO> fn = (entity -> entityToDto(entity));

        System.out.println("fn = " + fn);

        return new PageResultDTO<>(result,fn);
    }

}
