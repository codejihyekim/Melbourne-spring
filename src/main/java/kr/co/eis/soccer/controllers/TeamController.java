package kr.co.eis.soccer.controllers;

import kr.co.eis.soccer.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/Team")
public class TeamController {
    private final TeamService service;
}
