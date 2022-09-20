package com.example.boardproject.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")
@EntityListeners(value = {AuditingEntityListener.class})
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;

    @Column(length = 100, nullable = false)
    private String cContent;

    @Column(length = 20, nullable = false)
    private String cWriter;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime cDate;

    @Column(length = 20, nullable = false)
    private String cPw;

    @ManyToOne
    @JoinColumn(name = "bId")
    private Board board;
}
