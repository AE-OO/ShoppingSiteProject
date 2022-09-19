package com.example.boardproject.controller;

import com.example.boardproject.dto.BoardDTO;
import com.example.boardproject.dto.ProductDTO;
import com.example.boardproject.service.ShowService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/show")
public class ShowController {

    private final ShowService showService;

    /* 제품 상세 리뷰 보기 */
    @GetMapping("/showBoard/{bId}")
    public String showBoard(@PathVariable("bId") int bId, Model model){

        BoardDTO board = showService.getByBId(bId);
        model.addAttribute("board", board);

        return "showBoard";
    }
}
