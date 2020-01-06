package com.hkoo.markdownblog;

import com.hkoo.markdownblog.domain.enums.BoardType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;
@Slf4j
public class ModulTest {

    @Test
    public void BoardType생성_테스트(){
        String boardType;
        boardType = BoardType.valueOf("notice").getValue();
        log.info(boardType);
    }
}
