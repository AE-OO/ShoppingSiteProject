package com.example.boardproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardWriteDTO {
    private String bTitle;
    private String bWriter;
    private String bContent;
    private List<MultipartFile> pImageFiles;
    private String bPw;
}
