package kr.co.eis.services;

import kr.co.eis.domains.User;
import kr.co.eis.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.co.eis.services
 * fileName        : UserServiceImpl
 * author          : codejihyekim
 * date            : 2022-05-03
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-03         codejihyekim      최초 생성
 */

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public String login(User user) {
        return repository.login(user);
    }

    @Override
    public List<User> findALl() {
        return repository.findAll();
    }

    @Override
    public List<User> findAll(Sort sort) {
        return repository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public String delete(User user) {
        repository.delete(user);
        return "";
    }

    @Override
    public String put(User user) {
        repository.put(user);
        return "";
    }

    @Override
    public String save(User user) {
        repository.save(user);
        return null;
    }

    @Override
    public Optional<User> findById(String userid) {
        return repository.findById(0L); // userid 타입이 다름
    }

    @Override
    public boolean existsById(String userid) {
        return repository.existsById(0L); // userid 타입이 다름
    }


}