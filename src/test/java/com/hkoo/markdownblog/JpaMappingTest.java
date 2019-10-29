package com.hkoo.markdownblog;

import com.hkoo.markdownblog.domain.Board;
import com.hkoo.markdownblog.domain.User;
import com.hkoo.markdownblog.repository.BoardRepository;
import com.hkoo.markdownblog.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {
//
//    private final String boardTestTitle = "테스트";
//    private final String email = "test@gamil.com";
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    BoardRepository boardRepository;
//
//    @Before
//    public void init() {
//        User user = userRepository.save(User.builder()
//                .name("hkoo")
//                .password("test")
//                .email(email)
//                .createdDate(LocalDateTime.now())
//                .build());
//
//        boardRepository.save(Board.builder()
//        .title(boardTestTitle)
//        .content("컨텐츠")
//        .user(user).build());
//    }
//    @Test
//    public void 제대로_생성_됐는지_테스트() {
//        User user = userRepository.findByEmail(email);
//        assertThat(user.getName(), is("hkoo"));
//        assertThat(user.getPassword(), is("test"));
//        assertThat(user.getEmail(), is(email));
//
//        Board board = boardRepository.findByUser(user);
//        assertThat(board.getTitle(), is(boardTestTitle));
//        assertThat(board.getContent(), is("컨텐츠"));
//    }
}
