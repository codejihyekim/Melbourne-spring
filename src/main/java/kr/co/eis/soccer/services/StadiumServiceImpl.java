package kr.co.eis.soccer.services;

import kr.co.eis.soccer.repositories.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName: kr.co.eis.soccer.services
 * fileName        : StadiumServiceImpl
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
public class StadiumServiceImpl {
    private final StadiumRepository repository;
}
