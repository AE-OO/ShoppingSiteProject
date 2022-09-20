package com.example.boardproject.domain;

/**
 * 열거타입으로 넣었다.
 * JPA는 열거타입을 int타입 컬럼으로 넣는다.
 * 이유는 enum 클래스는 배열을 갖는다.
 */

public enum MemberType {
    USER("유저"),
    ADMIN("관리자"),
    BUSINESS("사업자");

    private final String identity;

    MemberType(String identity) {
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }
}