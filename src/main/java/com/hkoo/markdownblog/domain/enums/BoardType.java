package com.hkoo.markdownblog.domain.enums;

public enum BoardType {
    notice("공지사항"),
    free("잡담"),
    coding("프로그래밍"),
    funny("유머");

    private String value;

    BoardType(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
