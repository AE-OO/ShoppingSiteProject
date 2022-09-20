package com.example.boardproject.controller;

import com.example.boardproject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardRestController {

    private final CommentRepository commentRepository;

    /* 댓글 추가 - cw */
    @ResponseBody
    @RequestMapping(value = "/upload")
    public void uploadComment(@RequestParam("cContent") String cContent, @RequestParam("cWriter") String cWriter, @RequestParam("cPw") String cPw, @RequestParam("bId") String bId){
        int bid = Integer.parseInt(bId);
        commentRepository.uploadComment(cContent,cWriter,cPw,bid);
    }

    /* 댓글 삭제 - cw */
    @ResponseBody
    @PostMapping("/deleteComment")
    public void deleteComment(@RequestParam("cId") int cId){
        commentRepository.deleteById(cId);
    }

    /* 댓글 수정 - cw */
    @ResponseBody
    @PostMapping("/updateComment")
    public void updateComment(@RequestParam("cContent") String cContent, @RequestParam("cId") int cId){
        commentRepository.updateComment(cContent, cId);
    }
}
