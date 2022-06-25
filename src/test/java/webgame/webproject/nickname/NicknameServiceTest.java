package webgame.webproject.nickname;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NicknameServiceTest {
    
    @Test
    public void join() throws Exception {

        NicknameService nicknameService = new NicknameServiceImpl();

        //given
        Nickname nickname = new Nickname(1L,"사자", 100, Status.AVAILABLE);

        //when
        nicknameService.join(nickname);
        Nickname findNickname = nicknameService.findNickname("사자");

        //then
        Assertions.assertThat(findNickname.getName()).isEqualTo("사자");
    }
}
