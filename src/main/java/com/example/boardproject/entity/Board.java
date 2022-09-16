package com.example.boardproject.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="board")
@ToString
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bId;

    @Column(length = 30, nullable = false)
    private String bTitle;

    @Column(length = 20, nullable = false)
    private String bWriter;

    @Column(length = 100, nullable = false)
    private String bContent;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp bDate;

    @Column(length = 20, nullable = false)
    private String bPw;

    @ManyToOne
    @JoinColumn(name="pId")
    private Product pId;

}



