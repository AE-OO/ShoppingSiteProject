package com.example.boardproject.service;

import com.example.boardproject.dto.BoardDTO;
import com.example.boardproject.dto.PageRequestDTO;
import com.example.boardproject.dto.PageResultDTO;
import com.example.boardproject.entity.Board;


public interface BoardService {


    default BoardDTO entityToDto(Board board) {

        BoardDTO boardDTO = BoardDTO.builder()
                .bId(board.getBId())
                .bPw(board.getBPw())
                .bDate(board.getBDate())
                .bContent(board.getBContent())
                .bTitle(board.getBTitle())
                .bWriter(board.getBWriter())
                .pImageFiles(board.getPImageFiles())
                .pId(board.getPId())
                .build();

        return boardDTO;


    }


    default Board DtoToEntity(BoardDTO boardDTO) {

        Board entity = Board.builder()
                .bId(boardDTO.getBId())
                .bTitle(boardDTO.getBTitle())
                .bWriter(boardDTO.getBWriter())
                .bContent(boardDTO.getBContent())
                .bDate(boardDTO.getBDate())
                .pImageFiles(boardDTO.getPImageFiles())
                .bPw(boardDTO.getBPw())
                .pId(boardDTO.getPId())
                .build();

        return entity;
    }

    PageResultDTO<BoardDTO, Board> getList(int pId, PageRequestDTO pageRequestDTO);

}
