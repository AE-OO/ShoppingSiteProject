package com.example.boardproject.controller;
/**
 * created : OH
 * last update : 2022.09.19
 */

import com.example.boardproject.domain.UploadFile;
import com.example.boardproject.dto.BoardWriteDTO;
import com.example.boardproject.entity.Board;
import com.example.boardproject.entity.Product;
import com.example.boardproject.repository.ProductRepository;
import com.example.boardproject.repository.WriteRepository;
import com.example.boardproject.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class WriteController {

    private final WriteRepository writeRepository;
    private final FileService fileService;
    private final ProductRepository productRepository;


    @GetMapping("/write/{pId}")
    public String writeForm(@PathVariable int pId, Model model) {
        model.addAttribute("pId", pId);
        return "write";
    }

    @PostMapping("/write/{pId}")
    public String saveBoard(@ModelAttribute BoardWriteDTO boardWriteDTO,
                            RedirectAttributes redirectAttributes,
                            @PathVariable int pId) throws IOException {

        Optional<Product> result = productRepository.findById(pId);
        Product product = result.get();

        List<UploadFile> storeImageFiles =
                fileService.storeFiles(boardWriteDTO.getPImageFiles());

        Board board = new Board(boardWriteDTO.getBTitle(),
                boardWriteDTO.getBWriter(),
                boardWriteDTO.getBContent(),
                storeImageFiles,
                product);

        writeRepository.save(board);
//
//        redirectAttributes.addAttribute("bId", board.getBId());
        redirectAttributes.addFlashAttribute("bId", board.getBId());

        return "redirect:/";
    }

    /**
     * test 메서드 지워도 무방
     */
    @GetMapping("/test")
    public String test(Model model) {
        Optional<Board> result1 = writeRepository.findById(217);
        Board result = result1.get();
        model.addAttribute("img", result);
        return "layout/defaultForm";
    }
}

