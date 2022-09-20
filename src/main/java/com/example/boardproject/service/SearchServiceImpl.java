package com.example.boardproject.service;


import com.example.boardproject.entity.Board;
import com.example.boardproject.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//0916 ho 추가 - 검색기능 서비스 클래스
@Service
public class SearchServiceImpl implements SearchService{

    private SearchRepository searchRepository;

    @Autowired
    public SearchServiceImpl(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    @Transactional
    public Page<Board> search(String keyword, int pId, Pageable pageable) {
        Page<Board> postsList = searchRepository.searchMethod(keyword,pId,pageable);
        return postsList;
    }

}
