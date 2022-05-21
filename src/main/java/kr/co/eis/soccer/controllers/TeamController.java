package kr.co.eis.soccer.controllers;

import kr.co.eis.soccer.domains.Team;
import kr.co.eis.soccer.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.co.eis.soccer.controllers
 * fileName        : TeamController
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamController {
    private final TeamService service;

    //Embeded Methods
    @GetMapping("/findAll")
    public List<Team> findAll() {
        return service.findALl();
    }

    @GetMapping("/findAll/sort")
    public List<Team> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Team> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Team team) {
        return service.delete(team);
    }

    @PostMapping("/join")
    public String save(@RequestBody Team team) {
        return service.save(team);
    }

    @GetMapping("/findById/{teamId}")
    public Optional<Team> findById(@PathVariable String teamId) {
        return service.findById(teamId);
    }

    @GetMapping("/existsById/{teamId}")
    public boolean existsById(@PathVariable String teamId) {
        return service.existsById(teamId);
    }

}
