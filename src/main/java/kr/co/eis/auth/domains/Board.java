package kr.co.eis.auth.domains;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName: kr.co.eis.auth.domains
 * fileName        : Board
 * author          : codejihyekim
 * date            : 2022-05-18
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-18         codejihyekim      최초 생성
 */
@Component
@Entity
@Table(name="boards")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Eager
public class Board {
    @Id
    @Column(name = "board_id")
    @GeneratedValue private long userId;
    @Column private @NotNull String boardName;
    @Column(name = "created_date") @NotNull private String regDate;

    @OneToMany(mappedBy = "board")
    List<Article> articles = new ArrayList<>();
}
