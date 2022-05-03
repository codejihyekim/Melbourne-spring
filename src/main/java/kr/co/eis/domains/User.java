package kr.co.eis.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

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
public class User {
    private String userid;
    private String password;
    private String email;
    private String name;
    private String phone;
    private String birth;
    private String address;
}
