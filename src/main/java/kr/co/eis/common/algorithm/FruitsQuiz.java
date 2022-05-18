package kr.co.eis.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName: kr.co.eis.common.algorithm
 * fileName        : FruitsQuiz
 * author          : codejihyekim
 * date            : 2022-05-18
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-18         codejihyekim      최초 생성
 */
public class FruitsQuiz {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Solution{
        private int total, apple, grape, orange;

        @Override
        public String toString() {
            return String.format("total: %d apple: %d grape: %d orange: %d",total, apple, grape, orange);
        }
    }
    @FunctionalInterface interface ISolution{
        Solution Solution(Solution solution);
    }

    @Test
    void ISolutionTest(){

    }
}
