package kr.co.eis.board.repositories;

import kr.co.eis.board.domains.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName: kr.co.eis.board.repositories
 * fileName        : BoardRepository
 * author          : codejihyekim
 * date            : 2022-05-20
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-20         codejihyekim      최초 생성
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
