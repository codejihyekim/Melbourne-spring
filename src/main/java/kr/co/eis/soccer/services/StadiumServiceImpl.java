package kr.co.eis.soccer.services;

import kr.co.eis.soccer.domains.Stadium;
import kr.co.eis.soccer.repositories.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

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
public class StadiumServiceImpl implements StadiumService {
    private final StadiumRepository repository;


    @Override
    public List<Stadium> findALl() {
        return repository.findAll();
    }

    @Override
    public List<Stadium> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Stadium> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public String delete(Stadium stadium) {
        repository.delete(stadium);
        return "";
    }

    @Override
    public String save(Stadium stadium) {
        repository.save(stadium);
        return "";
    }

    @Override
    public Optional<Stadium> findById(String stadiumId) {
        return repository.findById(0L);

    }

    @Override
    public boolean existsById(String stadiumId) {
        return repository.existsById(0L);
    }
}
