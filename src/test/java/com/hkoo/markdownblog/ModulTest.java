package com.hkoo.markdownblog;

import com.hkoo.markdownblog.domain.enums.BoardType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ModulTest {

    @Test
    public void BoardType의_입력값에따른_출력_테스트(){
        BoardType boardType = BoardType.valueOf("free");
        log.info(boardType.getValue());
    }

    @Test
    public void test(){
        log.info(System.getProperty("user.name"));
    }
}
