package kr.co.eis.soccer.repositories;

import kr.co.eis.soccer.domains.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * packageName: kr.co.eis.soccer.repositories
 * fileName        : StadiumService
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */

interface StadiumCustomRepository{
    // 스타디움 전화번호 tel 을 변경하도록 하시오
    @Query(value = "update stadium s set s.tel=:tel where s.stadiumNo=:stadiumNo", nativeQuery = true)
    int update(@Param("tel") String tel);

}


@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long>, StadiumCustomRepository {
}
