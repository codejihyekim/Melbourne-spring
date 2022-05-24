package kr.co.eis.user.repositories;

import kr.co.eis.user.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * packageName: kr.co.eis.repositories
 * fileName        : UserRepository
 * author          : codejihyekim
 * date            : 2022-05-03
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-03         codejihyekim      최초 생성
 */

interface UserCustromRepository{

    // 000. 사용자의 비밀번호와 이메일을 수정하시오
    @Query(value = "update user u set u.password=:password, u.email=:email where u.userId=:userId"
            ,nativeQuery = true)
    int update(@Param("password") String password, @Param("email") String email);
    String login(User user);

}

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);
}
