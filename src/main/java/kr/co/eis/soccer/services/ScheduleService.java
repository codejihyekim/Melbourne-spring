package kr.co.eis.soccer.services;

import kr.co.eis.auth.domains.User;
import kr.co.eis.soccer.domains.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.co.eis.soccer.services
 * fileName        : ScheduleService
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */
public interface ScheduleService {


    List<Schedule> findALl();

    List<Schedule> findAll(Sort sort);

    Page<Schedule> findAll(Pageable pageable);

    long count();

    String delete(Schedule schedule);

    String save(Schedule schedule);

    Optional<Schedule> findById(String scheDate);

    boolean existsById(String scheDate);
}
