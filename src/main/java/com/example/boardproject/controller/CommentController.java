package com.example.boardproject.controller;

import com.example.boardproject.entity.Comment;
import com.example.boardproject.repository.CommentRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping("/reply/{bid}")
    public String showComments(@PathVariable("bid") int bid, Model model){
        model.addAttribute("comments", commentRepository.showCommentList(bid));
        model.addAttribute("bId", bid);
        return "/comment";
    }

    @RequestMapping("/comment")
    public String test(){
        return "/comment";
    }
}
