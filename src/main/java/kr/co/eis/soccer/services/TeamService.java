package kr.co.eis.soccer.services;

import kr.co.eis.auth.domains.User;
import kr.co.eis.soccer.domains.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.co.eis.soccer.services
 * fileName        : TeamService
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */
public interface TeamService {



    List<Team> findALl();

    List<Team> findAll(Sort sort);
    Page<Team> findAll(Pageable pageable);
    long count();

    String delete(Team team);

    String save(Team team);

    Optional<Team> findById(String teamId);

    boolean existsById(String teamId);
}
