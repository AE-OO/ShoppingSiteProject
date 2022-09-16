package com.example.boardproject.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Getter
@Builder
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;

    @Column(length = 100, nullable = false)
    private String cContent;

    @Column(length = 20, nullable = false)
    private String cWriter;

    @CreationTimestamp
    private Timestamp cDate;

    @Column(length = 20, nullable = false)
    private String cPw;

    @ManyToOne
    @JoinColumn(name="bId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Board board;
}