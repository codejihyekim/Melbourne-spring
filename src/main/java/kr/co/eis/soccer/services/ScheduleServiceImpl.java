package kr.co.eis.soccer.services;

import kr.co.eis.soccer.repositories.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName: kr.co.eis.soccer.services
 * fileName        : ScheduleServiceImpl
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
public class ScheduleServiceImpl {
    private final ScheduleRepository repository;
}
