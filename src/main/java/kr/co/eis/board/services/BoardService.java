package kr.co.eis.board.services;

import kr.co.eis.board.domains.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.co.eis.board.services
 * fileName        : BoardService
 * author          : codejihyekim
 * date            : 2022-05-20
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-20         codejihyekim      최초 생성
 */
public interface BoardService {
    List<Board> findAll();

    List<Board> findAll(Sort sort);
    Page<Board> findAll(Pageable pageable);
    long count();

    String delete(Board board);

    String save(Board board);

    Optional<Board> findById(String board);

    boolean existsById(String board);
}
