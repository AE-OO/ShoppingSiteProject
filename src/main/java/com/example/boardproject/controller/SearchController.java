package com.example.boardproject.controller;

import com.example.boardproject.dto.PageRequestDTO;
import com.example.boardproject.entity.Board;
import com.example.boardproject.repository.SearchRepository;
import com.example.boardproject.service.BoardService;
import com.example.boardproject.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Log4j2
@Controller
@RequiredArgsConstructor
public class SearchController {

    private final SearchRepository searchRepository;

    private final BoardService boardService;

//    0919 ho 추가- 검색기능
    private final SearchService searchService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("productList", searchRepository.productList());

        return "main";
    }

    @GetMapping("/product/{pId}")
    public String productList(@PathVariable("pId") int pId, Model model) {
        log.info("----------- /product/{pId}------------");
        model.addAttribute("pId", pId);

        System.out.println("pId = " + pId);

        return "redirect:/product/{pId}/list";
    }

    @GetMapping("/product/{pId}/list")
    public String list(@PathVariable("pId") int pId, PageRequestDTO pageRequestDTO, Model model) {
        log.info("list :" + pageRequestDTO);

        model.addAttribute("lists", boardService.getList(pId,pageRequestDTO));
        model.addAttribute("pId", pId);

        return "list";
    }

//    0919 ho 추가 - 검색기능
    @GetMapping("/search/{pId}")
    public String search(String keyword, Model model, @PathVariable int pId, Pageable pageable) {
        Page<Board> searchList = searchService.search(keyword, pId, pageable);
        model.addAttribute("searchList", searchList);
        model.addAttribute("pId",pId);

        return "posts-search";
    }



}
