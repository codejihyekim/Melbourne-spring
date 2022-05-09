package kr.co.eis.soccer.services;

import kr.co.eis.soccer.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName: kr.co.eis.soccer.services
 * fileName        : TeamServiceImpl
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */
@Service
@RequiredArgsConstructor
public class TeamServiceImpl {
    private final TeamRepository repository;
}
