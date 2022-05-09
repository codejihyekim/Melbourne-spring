package kr.co.eis.board.services;

import kr.co.eis.auth.domains.User;
import kr.co.eis.board.domains.Article;
import kr.co.eis.board.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.co.eis.board.services
 * fileName        : ArticleService
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */


public interface ArticleService {

    List<Article> findAll();
    List<Article> findAll(Sort sort);
    Page<Article> findAll(Pageable pageable);
    long count();
    String delete(Article article);
    String save(Article article);
}
