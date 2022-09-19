package com.example.boardproject.dto;

import com.example.boardproject.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {

    private int cId;
    private String cWriter;
    private String cContent;
    private LocalDateTime cDate;
    private String cPw;
    private Board board;

}