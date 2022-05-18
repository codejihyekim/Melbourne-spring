package kr.co.eis.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * packageName: kr.co.eis.common.algorithm
 * fileName        : CheckSamArray
 * author          : codejihyekim
 * date            : 2022-05-17
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-17         codejihyekim      최초 생성
 */
public class CheckSameArray {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Solution{
       /**
        private int[] arr1, arr2;
        private String res;

        @Override
        public String toString() {
            return String.format("res: %s",res);
        }*/
       private List<Integer> l;
    }
    @FunctionalInterface interface SolutionService{
        Boolean solution(Solution s1, Solution s2);
    }
    @Test
    void testSolution(){
        List<Solution> ls = Arrays.asList(
                Solution.builder().l(Arrays.asList(1,3,2)).build(),
                Solution.builder().l(Arrays.asList(2,3,1)).build()
        );
        SolutionService cs = (x, y) -> x.getL().containsAll(y.getL());
        System.out.println(cs.solution(ls.get(0), ls.get(1)));

        /**
        int[] arr1 = {1, 3, 2};
        int[] arr2 = {2, 3, 1};
        SolutionService c = e -> {
            String res = "";
            int count = 0;
            for(int i : e.getArr1()){
                for(int j: e.getArr2()){
                    if(i == j){
                        res = "true";
                    }else {
                        res = "false";
                    }
                }
            }
            return Solution.builder().res(res).build();
        };
        Solution s = Solution.builder().arr1(arr1).arr2(arr2).build();
        System.out.println(c.solution(s));*/
    }
}
