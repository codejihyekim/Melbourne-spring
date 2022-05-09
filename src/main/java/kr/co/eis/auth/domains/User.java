package kr.co.eis.auth.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * packageName: kr.co.eis.domains
 * fileName        : User
 * author          : codejihyekim
 * date            : 2022-05-03
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-03         codejihyekim      최초 생성
 */

@Data
@Component // 컴포넌트는 프로퍼티와 메소드의 집합이다.
@Entity
@Table(name="users")

public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private String userid;
    @Column(nullable = false) private String password;
    @Column(nullable = false) private String email;
    @Column(nullable = false) private String name;
    private String phone;
    private String birth;
    private String address;
}
