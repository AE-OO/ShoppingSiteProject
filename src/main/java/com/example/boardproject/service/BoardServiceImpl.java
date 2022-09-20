package com.example.boardproject.service;

import com.example.boardproject.dto.BoardDTO;
import com.example.boardproject.dto.PageRequestDTO;
import com.example.boardproject.dto.PageResultDTO;
import com.example.boardproject.entity.Board;
import com.example.boardproject.repository.BoardRepository;
import com.example.boardproject.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final SearchRepository searchRepository;

    @Override
    public PageResultDTO<BoardDTO, Board> getList(int pId,PageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("bId").descending());

        Page<Board> result = searchRepository.findByPId(pId,pageable);

        Function<Board, BoardDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result,fn);
    }

}