package kr.co.eis.user.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * packageName: kr.co.eis.auth.domains
 * fileName        : UserDto
 * author          : codejihyekim
 * date            : 2022-05-24
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-24         codejihyekim      최초 생성
 */
 // DB에서 화면으로 보낼 때 쓰는 컨테이너
@Component @Data
public class UserDTO {
    @ApiModelProperty(position =  1) private long userId;
    @ApiModelProperty(position =  2) String username;
    @ApiModelProperty(position =  3) String password;
    @ApiModelProperty(position =  4) String name;
    @ApiModelProperty(position =  5) String email;
    @ApiModelProperty(position =  6) private String regDate;
    @ApiModelProperty(position =  7) private String token;
    @ApiModelProperty(position =  8) private List<Role> roles; //role은 하나만 가지고 있다는 의미가 아니기 때문에
}
