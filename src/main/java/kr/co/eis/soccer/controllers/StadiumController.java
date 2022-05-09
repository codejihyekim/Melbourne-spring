package kr.co.eis.soccer.controllers;

import kr.co.eis.soccer.services.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName: kr.co.eis.soccer.controllers
 * fileName        : StadiumController
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */
@RestController
@RequestMapping("/Stadium")
@RequiredArgsConstructor
public class StadiumController {
    private final StadiumService service;

}
