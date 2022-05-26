package kr.co.eis.user.services;

import kr.co.eis.auth.domains.Messenger;
import kr.co.eis.user.domains.User;
import kr.co.eis.user.domains.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.co.eis.services
 * fileName        : UserService
 * author          : codejihyekim
 * date            : 2022-05-03
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-03         codejihyekim      최초 생성
 */

public interface UserService {

    UserDTO login(UserDTO user);
    List<User> findALl();
    List<User> findAll(Sort sort);
    Page<User> findAll(Pageable pageable);
    Messenger count();
    Messenger delete(User user);
    Messenger save(UserDTO user);
    Optional<User> findById(String userid);
    Messenger existsById(String userid);
    //custom
    List<User> findByUserName(String name);
    Messenger update(User user);

    Messenger logout();
}
