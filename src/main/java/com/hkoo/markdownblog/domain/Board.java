package com.hkoo.markdownblog.domain;


import com.hkoo.markdownblog.domain.enums.BoardType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDateTime;

@Data
@Getter
@NoArgsConstructor
@Entity
@Table
public class Board{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @OneToOne
    private Thumbnail thumbnail;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Board(String title, String content, LocalDateTime createdDate,
                 LocalDateTime updatedDate, User user, Thumbnail thumbnail,
                 BoardType boardType) throws IOException {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.user = user;
        this.boardType = boardType;
        this.thumbnail = thumbnail;
    }

    public void setCreatedDateNow() {
        this.createdDate = LocalDateTime.now();
    }

    public void updateDateTime(){
        this.updatedDate = LocalDateTime.now();
    }

    public void update(Board board) {
        this.title = board.title;
        this.content = board.content;
        this.boardType = board.boardType;
    }
}
