package kr.co.eis.board.domains;

/**
 * packageName: kr.co.eis.domains
 * fileName        : Board
 * author          : codejihyekim
 * date            : 2022-05-04
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-04         codejihyekim      최초 생성
 */

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Data
@Component
@Entity
@Table(name="Articles")

public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private String project;
    private String startDate;
    private String status;
    private String team;
    private String progress;
    private String actions;
}
