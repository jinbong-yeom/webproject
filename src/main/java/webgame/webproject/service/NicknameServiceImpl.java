package webgame.webproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webgame.webproject.domain.Nickname;
import webgame.webproject.repository.DatabaseNicknameRepository;
import webgame.webproject.repository.NicknameRepository;

import java.util.List;

//@Component
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NicknameServiceImpl implements NicknameService {

    private final DatabaseNicknameRepository nicknameRepository;


    @Override
    @Transactional
    public Long join(Nickname nickname) {
        validateDuplicateNickname(nickname);
        nicknameRepository.save(nickname);
        return nickname.getId();
    }

    private void validateDuplicateNickname(Nickname nickname) {
        List<Nickname> findNickname = nicknameRepository.findByName(nickname.getName());
        if (!findNickname.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }
    }

    @Override
    public List<Nickname> findAll() {
        return nicknameRepository.findAll();
    }

    @Override
    public Nickname findOne(Long id) {
        return nicknameRepository.findOne(id);
    }
}
