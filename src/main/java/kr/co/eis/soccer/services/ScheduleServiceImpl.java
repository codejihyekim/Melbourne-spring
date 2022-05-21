package kr.co.eis.soccer.services;

import kr.co.eis.soccer.domains.Schedule;
import kr.co.eis.soccer.repositories.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository repository;


    @Override
    public List<Schedule> findALl() {
        return repository.findAll();
    }

    @Override
    public List<Schedule> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Schedule> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public String delete(Schedule schedule) {
        repository.delete(schedule);
        return "";
    }

    @Override
    public String save(Schedule schedule) {
        repository.save(schedule);
        return "";
    }

    @Override
    public Optional<Schedule> findById(String scheDate) {
        return repository.findById(0L);

    }

    @Override
    public boolean existsById(String scheDate) {
        return repository.existsById(0L);
    }
}
