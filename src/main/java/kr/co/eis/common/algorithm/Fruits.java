package kr.co.eis.common.algorithm;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * packageName: kr.co.eis.common.algorithm
 * fileName        : Fruits
 * author          : codejihyekim
 * date            : 2022-05-17
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-17         codejihyekim      최초 생성
 */
public class Fruits {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class Solution{
        private int apple, grape, orange, total;
        private List<Solution> list;

        @Override
        public String toString() {
            return String.format("총합: %d원 사과평균: %d원 포도평균: %d원 오렌지평균: %d원",total,apple,grape,orange);
        }
    }
    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution s);
    }
    @Test
    void testSolution(){
        List<Solution> list = Arrays.asList(
                Solution.builder().apple(10000).grape(20000).orange(12000).build(),
                Solution.builder().apple(8000).grape(3000).orange(15000).build(),
                Solution.builder().apple(20000).grape(15000).orange(38000).build(),
                Solution.builder().apple(13000).grape(20000).orange(30000).build(),
                Solution.builder().apple(30000).grape(12000).orange(20000).build(),
                Solution.builder().apple(35000).grape(30000).orange(25000).build(),
                Solution.builder().apple(50000).grape(23000).orange(10000).build()
        );
        SolutionService f = e-> {
            int apple = 0;
            int grape = 0;
            int orange = 0;
            int total = 0;
            for(Solution solution: e.getList()){
                apple += solution.getApple();
                grape += solution.getGrape();
                orange += solution.getOrange();
                total = apple+grape+orange;
            }
            return Solution.builder().apple(apple/e.getList().size()).grape(grape/e.getList().size())
                    .orange(orange/e.getList().size()).total(total).build();
        };
        Solution s = Solution.builder().list(list).build();
        System.out.println(f.solution(s));
        /**
        int[][] price ={{10000,20000,12000},{8000,3000,15000},{20000,15000,38000},{13000,20000,30000}
                ,{30000,12000,20000},{35000,30000,25000},{50000,23000,10000}};
        SolutionService f = e -> {
            int total = 0;
            int apple = 0;
            int grape = 0;
            int orange = 0;
            for(int i = 0; i < price.length; i++){
                for(int j = 0; j < price[i].length; j++){
                    if(j == 0){
                        apple += price[i][j];
                    } else if(j == 1){
                        grape += price[i][j];
                    } else {
                        orange += price[i][j];
                    }
                    total += price[i][j];
                }
            }*/
        };
    }

