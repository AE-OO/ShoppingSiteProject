package com.example.boardproject.controller;

import com.example.boardproject.repository.SearchRepository;
import com.example.boardproject.service.BoardService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class SearchController {

    private final SearchRepository searchRepository;
    private final BoardService boardService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("productList", searchRepository.productList());
        return "main";
    }

    @GetMapping("/product/{pId}")
    public String productList(@PathVariable int pId, PageRequestDTO pageRequestDTO, Model model) {
        model.addAttribute("lists", boardService.getList(pId, pageRequestDTO));
        model.addAttribute("pId", pId);
        return "list";
    }

}
