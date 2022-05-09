package kr.co.eis.soccer.domains;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * packageName: kr.co.eis.soccer.domains
 * fileName        : Team
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */

@Component
@Entity
@Data
@Table(name="teams")
public class Team {
    @Id private Long id;
    @Column(nullable = false) private String teamID;
    private String regionName;
    private String teamName;
    private String eTeamName;
    private String origYyyy;
    @Column(nullable = false)  String stadiumId;
    private String zipCode1;
    private String zipCode2;
    private String address;
    private String ddd;
    private String tel;
    private String fax;
    private String homePage;
    private String ownerName;
}
