package kr.co.eis.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName: kr.co.eis.common.algorithm
 * fileName        : MaxMin
 * author          : codejihyekim
 * date            : 2022-05-17
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-17         codejihyekim      최초 생성
 */
public class MaxMin{

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Solution{
        private int[] arr;
        private int max, min;

        @Override
        public String toString() {
            return String.format("최소값: %d, 최대값: %d", min, max);
        }
    }
    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution s);
    }

    @Test
    void testSolution(){
        int[] arr = {3, 1, 9, 5, 10};
        SolutionService f = e -> {
            int max = 0;
            for(int i: e.getArr()){
                if(i > max) max = i;
            }
            int min = max;
            for(int i: e.getArr()){
                if(i < min) min = i;
            }
            return Solution.builder().min(min).max(max).build();
        };
        Solution s = Solution.builder().arr(arr).build();
        System.out.println(f.solution(s));
    }
}
