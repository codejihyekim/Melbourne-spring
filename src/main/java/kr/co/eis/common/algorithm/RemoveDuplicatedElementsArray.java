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
 * fileName        : RemoveDuplicateElementsArray
 * author          : codejihyekim
 * date            : 2022-05-17
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-17         codejihyekim      최초 생성
 */
public class RemoveDuplicatedElementsArray {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Solution{
        private List<Integer> l;

        @Override
        public String toString() {
            return String.format("중복제거한 값",l);
        }
    }
    @FunctionalInterface interface SolutionService{
        List<Integer> solution(List<Integer> l);
    }
    @Test
    void testSolution(){
        List<Integer> l = Arrays.asList(5, 10, 9, 27, 2, 8, 10, 4, 27, 1);
        SolutionService rd = x -> x.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(rd.solution(l));
    }
}
