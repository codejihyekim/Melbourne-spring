package kr.co.eis.soccer.controllers;


import kr.co.eis.soccer.domains.Player;
import kr.co.eis.soccer.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.co.eis.soccer.controllers
 * fileName        : PlayerController
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */
@RequestMapping("/players")
@RestController
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService service;

    //Embeded Methods
    @GetMapping("/findAll")
    public List<Player> findAll() {
        return service.findALl();
    }

    @GetMapping("/findAll/sort")
    public List<Player> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Player> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Player player) {
        return service.delete(player);
    }

    @PostMapping("/join")
    public String save(@RequestBody Player player) {
        return service.save(player);
    }

    @GetMapping("/findById/{playerId}")
    public Optional<Player> findById(@PathVariable String playerId) {
        return service.findById(playerId);
    }

    @GetMapping("/existsById/{playerId}")
    public boolean existsById(@PathVariable String playerId) {
        return service.existsById(playerId);
    }

}
