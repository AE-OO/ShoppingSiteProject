package com.example.boardproject.entity;

import com.example.boardproject.domain.MemberType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mId;

    @Column(length = 20, unique = true, nullable = false)
    private String loginId;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(nullable = false)
    private MemberType memberType;

    public Member(String loginId, String password, MemberType memberType) {
        this.loginId = loginId;
        this.password = password;
        this.memberType = memberType;
    }
}