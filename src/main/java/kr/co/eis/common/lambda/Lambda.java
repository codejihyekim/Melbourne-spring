package kr.co.eis.common.lambda;

import javax.persistence.criteria.CriteriaBuilder;

import static kr.co.eis.common.dataStructure.AppleList.Apple;

import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.function.*;


/**
 * packageName: kr.co.eis.common.lambda
 * fileName        : LambdaUtil
 * author          : codejihyekim
 * date            : 2022-05-11
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-11         codejihyekim      최초 생성
 */

public class Lambda {
    public static void main(String[] args) {
        /**
        System.out.println(integer("900"));
        System.out.println(string(50));
        System.out.println(
                string(
                        Arrays.asList(
                                new Apple.Builder().origin("영동").color("RED").price(1000).build(),
                                new Apple.Builder().origin("영동").color("BLUE").price(1500).build()
                        )));
        System.out.println(equals("홍", "홍"));
        System.out.println(array(7).length);*/
        System.out.println(random(1, 6));
    }
    public static int integer(String arg){
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(arg);
    }
    public static String string(Object arg){
        //String s = String.valueOf(object)
        Function<Object, String> f = String::valueOf;
        return f.apply(arg);
    }
    //두개 변수 비교
    public static boolean equals(String s1, String s2){
        BiPredicate<String, String> f = String::equals;
        return f.test(s1, s2);
    }
    // int [] arr = new int[8];
    // = int[]::new
    public static int[] array(int a){
        Function<Integer, int[]> f = int[]::new;
        return f.apply(a);
    }

    // Math.random
    public static int random(int a, int b){
        BiFunction<Integer, Integer, Integer> f = (t, u) -> (int)(Math.random()*u)+t;
        //Supplier<Double> f = Math::random;
        return f.apply(a, b);
    }
    //File file = new File("d:\\example\\new_directory");
    public static File makeFile(String a){
        Function<String, File> f = File::new;
        return f.apply(a);
    }
}
