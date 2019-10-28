package com.hkoo.markdownblog.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table
public class Thumbnail {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private Long board_idx;

    @Column
    private String originalFileName;

    @Column
    private String storedFilePath;

    @Column
    private Long fileSize;

    @Builder
    public Thumbnail(Long board_idx,String originalFileName, String storedFilePath, Long fileSize){
        this.board_idx = board_idx;
        this.originalFileName = originalFileName;
        this.storedFilePath = storedFilePath;
        this.fileSize = fileSize;
    }
}
