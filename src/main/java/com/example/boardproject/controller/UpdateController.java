package com.example.boardproject.controller;

import com.example.boardproject.mybatis.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UpdateController {

    @Autowired
    BoardDAO boardDAO;

    @GetMapping("/")
    public String home() {
        return "main";
    }

    @GetMapping("/show")
    public String viewTest(Model model,@Param("bId")int bId) {  //조회 화면
        model.addAttribute("bbb",boardDAO.getContent(bId));
        return "board/viewTest";
    }
    @RequestMapping("/update/{id}") //수정 화면
    public String boardUpdateForm(@PathVariable("id")int bId,Model model) {
        model.addAttribute("idid", boardDAO.updateSelect(bId));
        return "board/updateBoard";
    }
    @RequestMapping("/checkPW") //비밀번호 확인
    @ResponseBody
    String checkBPW(@RequestParam int bId, @RequestParam String inputPW)  {
        String a= boardDAO.checkPW(bId);
        if(a.equals(inputPW)){
            return "1";
        } else {
            return "0";
        }
    }
    @PostMapping ("/boardUpdate/{id}") //수정 DB 반영
    public String boardUpdate(@Param("title")String title, @Param("content")String content, @PathVariable("id")int bId) {
        boardDAO.update(title,content,bId);
        return "redirect:/";
    }
    @RequestMapping("/boardDelete/{id}") // 삭제 DB 반영
    public String boardDelete(@PathVariable("id")int bId) {
            boardDAO.delete(bId);
            return "redirect:/";
    }

}
