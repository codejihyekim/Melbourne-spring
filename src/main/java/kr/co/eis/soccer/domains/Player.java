package kr.co.eis.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * packageName: kr.co.eis.soccer.domains
 * fileName        : Player
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */
@Entity
@Data
@Component
@Table(name="players")
public class Player {
    @Id private Long id;
    @Column(nullable = false) private String playerId;
    @Column(nullable = false) private String teamId;
    private String playerName;
    private String ePlayerName;
    private String nickName;
    private String joinYyyy;
    private String position;
    private String backNo;
    private String nation;
    private String birthDate;
    private String solar;
    private String height;
    private String weight;
}
