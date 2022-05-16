package kr.co.eis.common.streams;

import kr.co.eis.common.dataStructure.AppleList;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * packageName: kr.co.eis.common.streams
 * fileName        : HelloStream
 * author          : codejihyekim
 * date            : 2022-05-16
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-16         codejihyekim      최초 생성
 */
//한국어 안녕, 영어로 Hello
public class HelloStream {
    @Data
    public static class Hello{
        private String greeting, inLanguage;

        public Hello(Builder builder){
            this.greeting = builder.greeting;
            this.inLanguage = builder.inLanguage;
        }
        @NoArgsConstructor
        static public class Builder{
            private String greeting, inLanguage;
            public Builder greeting(String greeting){this.greeting=greeting; return this;}
            public Builder inLanguage(String inLanguage){this.inLanguage=inLanguage; return this;}
            public Hello build(){return new Hello(this);}
        }
        @Override
        public String toString(){
            return String.format("[인사 스펙] greeting: %s, inLanguage: %s",greeting,inLanguage);
        }
    }

    interface HelloService{
        Set<String> greet(String[] arr);
    }
    static class HelloServiceImpl implements HelloService{

        @Override
        public Set<String> greet(String[] arr) {
            return Arrays.asList(arr)
                    .stream()
                    .filter(e -> e.startsWith("영어"))
                    .collect(Collectors.toSet());
        }
    }

    @Test
    void helloTest(){
        String[] arr = {"한국어 안녕","영어 Hello"};
        HelloService service = new HelloServiceImpl();
        Set<String> s = service.greet(arr);
        s.forEach(System.out::println);
    }
}
