package kr.co.eis.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.util.ApplicationContextTestUtils;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.List;

/**
 * packageName: kr.co.eis.common.algorithm
 * fileName        : PrimeNumber
 * author          : codejihyekim
 * date            : 2022-05-17
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-17         codejihyekim      최초 생성
 */
public class PrimeNumber {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Solution{
        private int start, end;
        private List<Integer> primes;

        @Override
        public String toString() {
            return String.format("");
        }
    }
   @FunctionalInterface interface SolutionService{
       List<Integer> solution(int start, int end);
   }
   @Test
    void testSolution(){
        /**
       SolutionService pn = (x, y) -> {
            List<Integer> primes =

       };
       System.out.println(pn.solution(1, 100));*/
    }
}
