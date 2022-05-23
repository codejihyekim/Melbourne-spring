package kr.co.eis.security.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

/**
 * packageName: kr.co.eis.security.domains
 * fileName        : Messenger
 * author          : codejihyekim
 * date            : 2022-05-23
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-23         codejihyekim      최초 생성
 */

@Getter @Builder
public class Messenger {
    private String message, code;
    private int status;
}
