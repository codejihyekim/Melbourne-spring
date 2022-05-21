package kr.co.eis.board.services;

import kr.co.eis.board.domains.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.co.eis.board.services
 * fileName        : ArticleService
 * author          : codejihyekim
 * date            : 2022-05-20
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-20         codejihyekim      최초 생성
 */
public interface ArticleService {

    List<Article> findAll();
    List<Article> findAll(Sort sort);
    Page<Article> findAll(Pageable pageable);

    long count();

    String delete(Article article);

    String save(Article article);

    Optional<Article> findById(String article);

    boolean existsById(String article);
}
