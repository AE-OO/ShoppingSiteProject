package com.example.boardproject.entity;

import com.example.boardproject.domain.UploadFile;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EntityListeners(value = {AuditingEntityListener.class})
public class Board {

    @Id
    @Column(name = "bId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bId;

    @Column(length = 30, name = "bTitle", nullable = false)
    private String bTitle;

    @Column(length = 20, name = "bWriter", nullable = false)
    private String bWriter;

    @Column(length = 100, name = "bContent")
    private String bContent;

    @ElementCollection
    @CollectionTable(name = "files",
            joinColumns = @JoinColumn(name = "fId"))
    private List<UploadFile> pImageFiles;

    @Column(length = 20, name = "bPw", nullable = false)
    private String bPw;

    @CreationTimestamp
    @Column(updatable = false, name = "bDate")
    private LocalDateTime bDate;

    @ManyToOne
    @JoinColumn(name = "pId")
    private Product pId;

    public Board(String bTitle, String bWriter, String bContent, List<UploadFile> pImageFiles, String bPw, Product pid) {
        this.bTitle = bTitle;
        this.bWriter = bWriter;
        this.bContent = bContent;
        this.pImageFiles = pImageFiles;
        this.bPw = bPw;
        this.pId = pid;
    }
}
