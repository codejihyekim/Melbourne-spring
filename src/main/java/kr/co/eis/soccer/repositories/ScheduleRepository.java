package kr.co.eis.soccer.repositories;

import kr.co.eis.soccer.domains.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * packageName: kr.co.eis.soccer.repositories
 * fileName        : ScheduleService
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */

interface ScheduleCustomRepository{
    // 스케줄 날짜만 수정이 되도록 하시오
    @Query(value = "update schedule s set s.scheDate=:scheDate where s.scheduleNo=:scheduleNo", nativeQuery = true)
    int update(@Param("scheDate") String scheDate);
}

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleCustomRepository{

}
