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
        private int [][] arr;

        @Override
        public String toString() {
            return String.format("",arr);
        }
    }

    @FunctionalInterface interface ISolution{
        void solution();
    }
    @Test
    void test(){
        ISolution is = () -> {
            for(int k = 2; k < 10; k+=4) {
                for (int i = 1; i < 10; i++) {
                    for (int j = k; j < k+4; j++) {
                        System.out.print(j + "*" + i+ "=" +(j*i)+"\t");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        };
        is.solution();
    }
}
