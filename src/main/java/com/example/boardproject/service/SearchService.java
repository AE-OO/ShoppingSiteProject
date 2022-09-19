package com.example.boardproject.service;

import com.example.boardproject.dto.BoardDTO;
import com.example.boardproject.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;

//0919 ho 추가 - 검색기능 서비스인터페이스
public interface SearchService {
    @Transactional
//    Page<Board> search(String keyword, Pageable pageable);
    Page<Board> search(String keyword, int pId, Pageable pageable);
}
