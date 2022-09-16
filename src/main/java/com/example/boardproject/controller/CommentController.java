package com.example.boardproject.controller;

import com.example.boardproject.entity.Comment;
import com.example.boardproject.repository.CommentRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

//    @RequestMapping("/reply/{bid}")
//    public String showComments(@PathVariable("bid") int bid, Model model){
//        model.addAttribute("comments", commentRepository.showCommentList(bid));
//        model.addAttribute("bId", bid);
////        commentRepository.showCommentList(bid);
//        return "/commentPage";
////        return "/comment";
//    }

//    @RequestMapping("/reply")
//    public void showComments2(){
////        model.addAttribute("comments", commentRepository.showCommentList(bid));
////        model.addAttribute("bId", bid);
//        commentRepository.showCommentList(1);
////        return "/commentPage";
////        return "/comment";
//    }

    @ResponseBody
    @RequestMapping("/reply/{bid}")
    public List<Comment> showComments(@PathVariable("bid") int bid){
//        List<Comment> comList = commentRepository.showCommentList(bid);
//        String ss = "<ul>";
//        for (Comment comment : comList) {
//            ss += comment;
//        }
        return commentRepository.showCommentList(bid);
//        model.addAttribute("comments", commentRepository.showCommentList(bid));
//        model.addAttribute("bId", bid);
    }

    @ResponseBody
    @RequestMapping(value = "/upload")
    public void uploadComment(@RequestParam("cContent") String cContent, @RequestParam("cWriter") String cWriter, @RequestParam("cPw") String cPw,@RequestParam("bId") String bId){
        int bid = Integer.parseInt(bId);
        commentRepository.uploadComment(cContent,cWriter,cPw,bid);
    }


    @ResponseBody
    @PostMapping("/deleteComment")
    public void deleteComment(@RequestParam("cId") int cId){
        commentRepository.deleteById(cId);
    }

    @PostMapping("/updateComment")
    public void updateComment(@RequestParam("cId") int cId){
//        commentRepository.
    }
}
