package webgame.webproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webgame.webproject.domain.Nickname;
import webgame.webproject.repository.NicknameRepository;

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
