package webgame.webproject.nickname;

import org.springframework.stereotype.Service;

@Service
public class NicknameServiceImpl implements NicknameService {

    private final NicknameRepository nicknameRepository;


    public NicknameServiceImpl(NicknameRepository nicknameRepository) {
        this.nicknameRepository = nicknameRepository;
    }

    @Override
    public void join(Nickname nickname) {
        nicknameRepository.save(nickname);
    }

    @Override
    public Nickname findNickname(String name) {
        return nicknameRepository.findByName(name);
    }
}
