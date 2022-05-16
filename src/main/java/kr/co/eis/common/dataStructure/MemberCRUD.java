package kr.co.eis.common.dataStructure;

import kr.co.eis.board.domains.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.tuple.InMemoryValueGenerationStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * packageName: kr.co.eis.common.dataStructure
 * fileName        : MemberCRUD
 * author          : codejihyekim
 * date            : 2022-05-09
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-09         codejihyekim      최초 생성
 */

public class MemberCRUD {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        MemberService service = new MemberServiceImpl();
        while(true){
            System.out.println("0.exit 1.save 2.update 3.delete 4.findById 5.findByName 6.findAll 7.count 8.existsById 9.clear");
            switch (s.next()){
                case "0": return;
                case "1":
                    Member hong = new Member.Builder("hong")
                        .email("hong@test.com")
                        .password("1")
                        .name("홍길동")
                        .name("010-0000-9999")
                        .profileImg("hong.jpg")
                        .build();
                    service.save(hong);
                    Member kim = new Member.Builder("kim")
                            .email("kim@test.com")
                            .password("1")
                            .name("김유신")
                            .name("010-4785-9385")
                            .profileImg("kim.jpg")
                            .build();
                    service.save(kim);
                    Member you = new Member.Builder("you")
                            .email("hong@test.com")
                            .password("1")
                            .name("유관순")
                            .name("010-0000-9999")
                            .profileImg("hong.jpg")
                            .build();
                    service.save(you);
                    break;
                case "2":
                    Member m = new Member();
                    m.setUserid("kim");
                    //service.update();

                    break;
                case "3":
                    Member temp = new Member();
                    temp.setUserid("kim");
                    service.delete(temp);
                    break;
                case "4":
                    String res = (service.findById("kim") == null) ? "해당 회원이 없습니다." : "해당 회원이 있습니다.";
                    System.out.println(res);
                    /**
                    if(service.findById("kim") == null){
                        System.out.println("해당 회원이 없습니다.");
                    }else {
                    System.out.println(service.findById("kim"));}**/
                    break;
                case "5":

                    break;
                case "6":
                    System.out.println("총 회원목록:" + service.findAll());
                    break;
                case "7":
                    System.out.println("총 회원수:" + service.count()+"명");
                    break;
                case "8":
                    System.out.println(service.existsById("kim"));
                    break;
                case "9":
                    service.clear();
                    break;
                default: break;
            }
        }
    }
    @Test
    void MemberTest(){
        Scanner scanner = new Scanner(System.in);
        MemberService service = new MemberServiceImpl();
        System.out.println("### 1.save ###");
        Member hong = new Member.Builder("hong")
                .email("hong@test.com")
                .password("1")
                .name("홍길동")
                .phone("010-0000-9999")
                .profileImg("hong.jpg")
                .build();
        service.save(hong);
        Member kim = new Member.Builder("kim")
                .email("kim@test.com")
                .password("2")
                .name("김유신")
                .phone("010-4785-9385")
                .profileImg("kim.jpg")
                .build();
        service.save(kim);
        Member you = new Member.Builder("you")
                .email("hong@test.com")
                .password("3")
                .name("유관순")
                .phone("010-0000-9999")
                .profileImg("hong.jpg")
                .build();
        service.save(you);
        System.out.println("### 2.count ###");
        System.out.println(service.count());
        System.out.println("### 3.findAll ###");
        System.out.println(service.findAll());
        System.out.println("### 4.findId ###");
        System.out.println(service.findById("kim"));
        /**
        System.out.println("### 5.update");
        Member m = new Member();
        m.setUserid("kim");
        service.update(m, new Member.Builder("park").email("park@test.com").password("4").name("박민근").phone("010-3975-9624").profileImg("park.jps").build());
        System.out.println("### 4.findId ###");
        System.out.println("수정된것 확인:"+service.findById("park"));*/
        System.out.println("### 6.delete ###");
        Member m = new Member();
        m.setUserid("kim");
        service.delete(m);
        System.out.println("삭제후 카운트 감소확인:"+service.count());
        System.out.println("### 7.clear ###");
        service.clear();
        System.out.println("clear 후 카운트 0 확인:" +service.count());
    }

    @Data @NoArgsConstructor
    static class Member{
        protected String userid, name, password, profileImg, phone, email;

        public Member(Builder builder) {
            this.userid = builder.userid;
            this.name = builder.name;
            this.password = builder.password;
            this.profileImg = builder.profileImg;
            this.phone = builder.phone;
            this.email = builder.email;
        }

        static class Builder{
            private String userid, name, password, profileImg, phone, email;
            public Builder(String userid){this.userid=userid;}
            public Builder name(String name){this.name=name; return this;}
            public Builder password(String password){this.password=password;return this;}
            public Builder profileImg(String profileImg){this.profileImg=profileImg;return this;}
            public Builder phone(String phone){this.phone=phone; return this;}
            public Builder email(String email){this.email=email; return this;}
            Member build(){return new Member(this);}
        }

        @Override
        public String toString(){
            return String.format("[사용자 스펙] userid: %s, name: %s, password: %s, profileImg: %s, phone: %s, email: %s",
                    userid, name, password, profileImg, phone, email);
        }
    }

     interface MemberService{
        void save(Member member);
        void update(Member member);
        void delete(Member member);
        Member findById(String id);
        List<Member> findByName(String name);
        List<Member> findAll();
        int count();
        boolean existsById(String id);
        void clear();
    }

    static class MemberServiceImpl implements MemberService{
        private final Map<String, Member> map;

        MemberServiceImpl(){
            this.map = new HashMap<>();
        }
        @Override
        public void save(Member member){
            map.put(member.getUserid(), member);
        }

        @Override
        public void update(Member member) {
            map.replace(member.getUserid(), member);
        }

        @Override
        public void delete(Member member) {
            map.remove(member.getUserid());
        }

        @Override
        public Member findById(String id) {
            return map.get(id);
        }

        @Override
        public List<Member> findByName(String name) {
            return (List<Member>) map.get(name);
        }

        @Override
        public List<Member> findAll() {
            return new ArrayList<>(map.values());
        }

        @Override
        public int count() {
            return map.size();
        }

        @Override
        public boolean existsById(String id) {
            return map.containsKey(id);
        }

        @Override
        public void clear() {
            map.clear();
        }

    }
}
