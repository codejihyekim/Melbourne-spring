package kr.co.eis.user.services;

import kr.co.eis.auth.configs.AuthProvider;
import kr.co.eis.auth.domains.Messenger;
import kr.co.eis.auth.exception.SecurityRuntimeException;

import kr.co.eis.user.domains.Role;
import kr.co.eis.user.domains.User;
import kr.co.eis.user.domains.UserDTO;
import kr.co.eis.user.repositories.UserRepository;
import kr.co.eis.common.dataStructure.Box;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kr.co.eis.common.lambdas.Lambda.longParse;
import static kr.co.eis.common.lambdas.Lambda.string;

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
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final AuthProvider provider;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO login(User user) {
        try {
            UserDTO userDTO = modelMapper.map(user, UserDTO.class); // class로 옮겨담는다.
            User findUser = repository.findByUsername(user.getUsername()).orElse(null);
            String pw = repository.findByUsername(user.getUsername()).get().getPassword(); //들어온 이름으로 db에 있는 비번을 가져온다
            boolean checkPassword = encoder.matches(user.getPassword(), pw); //들어온 비번과 db의 비번을 매치
            String username = user.getUsername();
            List<Role> roles = findUser.getRoles();
            String token = checkPassword ? provider.createToken(username, roles) : "Wrong Password"; // 매치가 맞으면 이름과 역할을 보낸다.
            userDTO.setToken(token);
            return userDTO; //화면으로 보냄
        }catch (Exception e){
            throw new SecurityRuntimeException("유효하지 않은 아이디/비밀번호", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public List<User> findALl() {
        return repository.findAll();
    }

    @Override
    public List<User> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Messenger count() {
        return Messenger.builder().message(string(repository.count())).build();
    }

    @Override
    public Messenger delete(User user) {
        repository.delete(user);
        return Messenger.builder().message("").build();
    }

    @Override
    public Messenger save(User user) {
        String result = "";
        if(repository.findByUsername(user.getUsername()).isEmpty()) {
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            repository.save(User.builder().password(encoder.encode(user.getPassword()))
                    .roles(list).build());
            result = "SUCCESS";
        }else {
            result = "FAIL";
        }
        return Messenger.builder().message(result).build();
    }

    @Override
    public Optional<User> findById(String userid) {
        return repository.findById(0L); // userid 타입이 다름
    }

    @Override
    public Messenger existsById(String userid) {
        return repository.existsById(longParse(userid))
                ? Messenger.builder().message("EXIST").build()
                :Messenger.builder().message("NOT_EXIST").build(); // userid 타입이 다름
    }

    @Override
    public List<User> findByUserName(String name) {
        List<User> ls = repository.findAll();
        Box<String, User> box = new Box<>();
        //ls = box.findByUserName(ls, name);
        //ls.stream().filter(...)
        return null;
    }
    @Override
    public Messenger update(User user) {
        return Messenger.builder().build();
    }

    @Override
    public Messenger logout() {
        return Messenger.builder().build();
    }
}