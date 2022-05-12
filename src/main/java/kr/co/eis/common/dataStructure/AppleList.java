package kr.co.eis.common.dataStructure;

import static kr.co.eis.common.lambda.Lambda.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * packageName: kr.co.eis.common.dataStructure
 * fileName        : AppleList
 * author          : codejihyekim
 * date            : 2022-05-11
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-11         codejihyekim      최초 생성
 */
//Apple color price origin(영동, 풍기)
public class AppleList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AppleService service = new AppleServiceImpl();
        while(true){
            System.out.println("0.exit 1.save 2.update 3.delete 4.findById 5.findByOrigin 6.findAll 7.count 8.existsById 9.clear");
            switch (s.next()){
                case "0": return;
                case "1":
                    Apple yd = new Apple.Builder()
                            .origin("영동")
                            .color("RED")
                            .price(1000)
                            .build();
                    service.save(yd);
                    Apple yd2 = new Apple.Builder()
                        .origin("영동")
                        .color("BLUE")
                        .price(1500)
                        .build();
                    service.save(yd2);
                    Apple pg = new Apple.Builder()
                            .origin("풍기")
                            .color("RED")
                            .price(2000)
                            .build();
                    service.save(pg);
                    break;
                case "2":
                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":
                    System.out.println("findByOrigin");
                    System.out.println(service.findByOrigin("영동"));
                    break;
                case "6":
                    System.out.println("총 사과목록:" + service.findAll());
                    break;
                case "7":
                    System.out.println(service.count());
                    break;
                case "8":

                    break;
                case "9":
                    service.clear();
                    break;
                case "10":
                    System.out.println("사과 가격은"+ integer("1000"));
                    System.out.println("내가 만든 배열의 사이즈는:"+array(7));
                    break;
                default: break;
            }
        }
    }
    @Data
    public static class Apple{
        private String color, origin;
        private int price;

        public Apple(Builder builder) {
            this.color = builder.color;
            this.origin = builder.origin;
            this.price = builder.price;
        }
        @NoArgsConstructor
        static public class Builder{
            private String color, origin;
            private int price;
            public Builder color(String color){this.color=color; return this;}
            public Builder origin(String origin){this.origin=origin;return this;}
            public Builder price(int price){this.price=price;return this;}
            public Apple build(){return new Apple(this);}
        }
        @Override
        public String toString(){
            return String.format("[사과 스펙] color: %s, origin: %s, price: %d",
                    color, origin, price);
        }
    }

    interface AppleService{
        void save(Apple apple);
        void update(int i, Apple apple);
        void delete(Apple apple);
        Apple findById(int i);
        List<Apple> findByOrigin(String origin);
        List<Apple> findByColor(String color);
        List<Apple> findAll();
        int count();
        void clear();
    }

    static class AppleServiceImpl implements AppleService{

        private final List<Apple> list;

        AppleServiceImpl() {
            this.list = new ArrayList<>();
        }

        @Override
        public void save(Apple apple) {
            list.add(apple);
        }

        @Override
        public void update(int i, Apple apple) {
            list.set(i, apple);
        }

        @Override
        public void delete(Apple apple) {
            list.remove(apple);
        }

        @Override
        public Apple findById(int i) {
            return list.get(i);
        }

        @Override
        public List<Apple> findByOrigin(String origin) {
           return list.stream()
                   .filter(apple -> apple.getOrigin().equals(origin))
                   .collect(Collectors.toList());
        }

        @Override
        public List<Apple> findByColor(String color) {
            return list.stream()
                    .filter(apple -> apple.getColor().equals(color))
                    .collect(Collectors.toList());
        }

        @Override
        public List<Apple> findAll() {
            return list;
        }

        @Override
        public int count() {
            return list.size();
        }

        @Override
        public void clear() {
            list.clear();
        }
    }

}
