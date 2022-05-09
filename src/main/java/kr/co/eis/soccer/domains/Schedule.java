package kr.co.eis.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * packageName: kr.co.eis.soccer.domains
 * fileName        : Schedule
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */

@Component
@Data
@Entity
@Table(name="schdules")
public class Schedule {
    @Id private Long id;
    @Column(nullable = false) private String stadiumId;
    @Column(nullable = false) private String scheDate;
    private String guban;
    private String homeTeamId;
    private String awayTeamId;
    private String homeScore;
    protected String awayScore;
}
