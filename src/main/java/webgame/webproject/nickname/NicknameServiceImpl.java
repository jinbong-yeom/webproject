package webgame.webproject.nickname;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
@RequiredArgsConstructor
public class NicknameServiceImpl implements NicknameService {

    private final NicknameRepository nicknameRepository;


    @Override
    public void join(Nickname nickname) {
        nicknameRepository.save(nickname);
    }

    @Override
    public Nickname findNickname(String name) {
        return nicknameRepository.findByName(name);
    }
}
