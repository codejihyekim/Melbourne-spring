package kr.co.eis.soccer.repositories;

import kr.co.eis.soccer.domains.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName: kr.co.eis.soccer.repositories
 * fileName        : TeamService
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */

interface TeamCustomRepository{
    //000. 팀의 전화번호와 팩스번호를 수정하시오
    @Query(value = "update team t set t.tel=:tel, t.fax=:fax where t.teamNo=:teamNo"
            , nativeQuery = true)
    String update(@Param("tel") String tel, @Param("fax") String fax);

    //01. 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오
    @Query(value="select t.teamName as teamName from team t order by t.teamName", nativeQuery = true)
    List<String> findTeamNameAsc();

    //005-2 수원팀의 ID는?
    @Query(value = "select t.teamId as teamId from team t where t.regionName=:regionName",nativeQuery = true)
    List<String> findTeamIdAsc();
}

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

}
