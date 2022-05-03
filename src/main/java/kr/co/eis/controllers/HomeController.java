package kr.co.eis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * packageName: kr.co.eis.controllers
 * fileName        : HomeController
 * author          : codejihyekim
 * date            : 2022-05-03
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-03         codejihyekim      최초 생성
 */

@RestController
public class HomeController {
    @GetMapping("/")
    public String now(){
        return new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(new Date());
    }
}
