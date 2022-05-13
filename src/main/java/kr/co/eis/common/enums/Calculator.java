package kr.co.eis.common.enums;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.function.BiFunction;

/**
 * packageName: kr.co.eis.common.enums
 * fileName        : Calculator
 * author          : codejihyekim
 * date            : 2022-05-13
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-13         codejihyekim      최초 생성
 */

public class Calculator {
    @RequiredArgsConstructor enum Operation{
        PLUS("+",(a,b) -> a+b),
        MINUS("-", (a, b) -> a-b),
        MULTI("*", (a, b) -> a*b),
        DIVIDE("/", (a, b) -> a/b)
        ;
        private final String opcode;
        private final BiFunction<Integer, Integer, Integer> f;
        @Override public String toString() {return opcode;}
        public int apply(int a, int b){return f.apply(a,b);}
    }
    @Test
    void calculatorTest(){
        System.out.println("+:"+Operation.PLUS.apply(7, 5));
        System.out.println("-:"+Operation.MINUS.apply(7, 5));
        System.out.println("*:"+Operation.MULTI.apply(7, 5));
        System.out.println("/:"+Operation.DIVIDE.apply(7, 5));
    }
}
