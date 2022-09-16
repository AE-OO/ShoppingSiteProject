package com.example.boardproject.dto;

import com.example.boardproject.entity.Product;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BoardDTO {
        private int bId;
        private String bTitle;
        private String bWriter;
        private LocalDateTime bDate;
        private String bContent;
        private String bImage;
        private String bPw;
        private Product product;
}
