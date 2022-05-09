package kr.co.eis.soccer.services;

import kr.co.eis.soccer.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName: kr.co.eis.soccer.services
 * fileName        : PlayerServiceImpl
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
public class PlayerServiceImpl implements PlayerService{
    private final PlayerRepository repository;
    // 지혜 하이염 ㅇ.<
}
