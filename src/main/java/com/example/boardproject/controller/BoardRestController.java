package com.example.boardproject.controller;

import com.example.boardproject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class BoardRestController {

    private final CommentRepository commentRepository;

    /* 댓글 추가 - cw */
    @ResponseBody
    @RequestMapping(value = "/upload")
    public void uploadComment(@RequestParam("cContent") String cContent, @RequestParam("bId") int bId, HttpServletRequest request){
        /* 세션 받아옴 */
        HttpSession session = request.getSession();

        if(!session.getAttribute("loginMember").equals(null)){
            String loginID = (String) session.getAttribute("loginID");
            System.out.println("=========================================");
            System.out.println(loginID);
            System.out.println(bId);
//            int bid = Integer.parseInt(bId);
            commentRepository.uploadComment(cContent,loginID,bId);
        }else{
            commentRepository.uploadComment(cContent,"익명댓글",bId);
        }
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
