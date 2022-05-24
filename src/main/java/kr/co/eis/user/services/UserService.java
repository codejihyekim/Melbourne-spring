package kr.co.eis.user.services;

import kr.co.eis.user.domains.User;
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

    String login(User user);
    List<User> findALl();
    List<User> findAll(Sort sort);
    Page<User> findAll(Pageable pageable);
    long count();
    String delete(User user);
    String save(User user);
    Optional<User> findById(String userid);
    boolean existsById(String userid);
    //custom
    List<User> findByUserName(String name);
    String update(User user);
}
