package kr.co.eis.common.streams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName: kr.co.eis.common.streams
 * fileName        : PersonStream
 * author          : codejihyekim
 * date            : 2022-05-16
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-16         codejihyekim      최초 생성
 */
public class PersonStream {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Person{
        private String name,ssn;

        @Override
        public String toString(){
            String res = "";
            String gender = ssn.substring(7,8);
            int age = (1123 - Integer.parseInt(ssn.substring(0, 2)))%100;
            /**
             * int age
            if(Integer.parseInt(ssn.substring(7, 8))<=2){
                age = 2023 - (Integer.parseInt(ssn.substring(0, 2))+1900);
            }else {
                age = 2023- (Integer.parseInt(ssn.substring(0, 2))+2000);
            }*/

//            int age = (Integer.parseInt(ssn.substring(7, 8))<=2) ?
//                    2023 - (Integer.parseInt(ssn.substring(0, 2))+1900):
//                    2023- (Integer.parseInt(ssn.substring(0, 2))+2000);
           switch (gender){
                case "1": case "3":
                    res = "남자";break;
                case "2": case "4":
                    res = "여자";break;
            }
           return
            String.format("이름 %s의 성별은 %s이고 나이는 %d입니다.",name, res, age);
        }
    }
    interface PersonService{
        Person search(List<Person> p);
    }

    static class PersonServiceImpl implements PersonService{

        @Override
        public Person search(List<Person> p) {
            return p.stream()
                    .filter(e -> e.getName().equals("김유신"))
                    .collect(Collectors.toList()).get(0);
        }
    }
    @Test
    void personStreamTest(){
        List<Person> p = Arrays.asList(
                Person.builder().name("홍길동").ssn("900120-1").build(),
                Person.builder().name("김유신").ssn("970620-1").build(),
                Person.builder().name("유관순").ssn("040920-4").build()
        );
        System.out.println(
                new PersonServiceImpl()
                .search(p));
        //"홍길동","900120-1"
        //"김유신","970620-1"
        //"유관순","040920-4"
        //남성, 여성 판단 로직 나이 출력
    }

}
