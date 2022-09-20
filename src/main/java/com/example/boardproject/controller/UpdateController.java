package com.example.boardproject.controller;

import com.example.boardproject.domain.UploadFile;
import com.example.boardproject.mybatis.BoardDAO;
import com.example.boardproject.repository.UpdateRepository;
import com.example.boardproject.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/board")
public class UpdateController {

    @Autowired
    BoardDAO boardDAO;
    @Autowired
    FileService fileService;
    @Autowired
    UpdateRepository updateRepository;

    @RequestMapping("/update/{id}") //수정 화면
    public String boardUpdateForm(@PathVariable("id") int bId, Model model) {
        model.addAttribute("idid", boardDAO.updateSelect(bId));
        model.addAttribute("imageName",boardDAO.selectImage(bId));
        return "updateBoard";
    }

    @PostMapping("/boardUpdate/{id}") //수정 DB 반영
    public String boardUpdate(@Param("title") String title, @Param("content") String content, @RequestParam("pImageFiles") MultipartFile image, @PathVariable("id") int bId) throws IOException {
        System.out.println("================" + content);
        if (image == null) {
            boardDAO.update(title, content, bId);
        }
        UploadFile uploadFile = fileService.storeFile(image);
        boardDAO.deleteImage(bId);
        boardDAO.update(title, content, bId);
        boardDAO.insertImage(bId,uploadFile.getStoreFileName(),uploadFile.getUploadFileName());

        return "redirect:/";
    }

    @RequestMapping("/boardDelete/{id}") // 삭제 DB 반영
    public String boardDelete(@PathVariable("id") int bId) {
        updateRepository.deleteById(bId);
        return "redirect:/";
    }
}
