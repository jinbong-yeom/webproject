package webgame.webproject.nickname;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import webgame.webproject.AppConfig;
import webgame.webproject.domain.Nickname;
import webgame.webproject.domain.Status;
import webgame.webproject.repository.NicknameRepository;
import webgame.webproject.service.NicknameService;

@SpringBootTest
public class NicknameServiceTest {

    NicknameService nicknameService;
    NicknameRepository nicknameRepository;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        nicknameService = appConfig.nicknameService();
        nicknameRepository = appConfig.nicknameRepository();
    }

    @Test
    public void join() throws Exception {
        //given
        Nickname nickname = new Nickname(1L,"사자", 100, Status.AVAILABLE);

        //when
        nicknameService.join(nickname);
        Nickname findNickname = nicknameService.findNickname("사자");

        //then
        Assertions.assertThat(findNickname.getName()).isEqualTo("사자");
    }
}
