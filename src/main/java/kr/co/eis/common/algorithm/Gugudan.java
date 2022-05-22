package kr.co.eis.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * packageName: kr.co.eis.common.algorithm
 * fileName        : Gugudan
 * author          : codejihyekim
 * date            : 2022-05-17
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-17         codejihyekim      최초 생성
 */
public class Gugudan {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Solution{
        private int num;
        private String result;

        @Override
        public String toString() {
            return result;
        }
    }

    @FunctionalInterface interface ISolution{Solution solution(Solution s);}
    @FunctionalInterface interface IMinseoGugudan{ void solution();}
    @FunctionalInterface interface IJinyoungGugudan{ Solution solution(Solution s);}

    static class Service{
        static IMinseoGugudan iMinseo = () -> {
            for(int k = 2; k < 10; k+=4) {
                for (int i = 1; i < 10; i++) {
                    for (int j = k; j < k+4; j++) {
                        System.out.print(j + "*" + i+ "=" +(j*i)+"\t");
                    }
                    System.out.println("\n");
                }
                System.out.println("\n");
            }
        };
        static IJinyoungGugudan iJinyoung = e -> {
            String result = "";
            for(int k = 2; k <= e.getNum(); k+=4) {
                for (int i = 1; i <= e.getNum(); i++) {
                    for (int j = k; j < k+4; j++) {
                        result +=  j + "*" + i+ "=" +(j*i)+"\t";
                    }
                    result += '\n';
                }
                result += '\n';
            }
            return Solution.builder().result(result).build();
        };

    }
    @Test
    void test(){
        //Service.iMinseo.solution();
        System.out.println(Service.iJinyoung.solution(Solution.builder().num(19).build()));
    }

}
