package com.example.boardproject.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @JoinColumn
    private Board board;
}
