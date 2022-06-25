package webgame.webproject.nickname;

public class NicknameServiceImpl implements NicknameService {
    private final NicknameRepository nicknameRepository = new MemoryNicknameRepository();


    @Override
    public void join(Nickname nickname) {
        nicknameRepository.save(nickname);
    }

    @Override
    public Nickname findNickname(String name) {
        return nicknameRepository.findByName(name);
    }
}
