package kr.co.eis.common.dataStructure;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName: kr.co.eis.common.dataStructure
 * fileName        : BmiList
 * author          : codejihyekim
 * date            : 2022-05-11
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-11         codejihyekim      최초 생성
 */
//키:height 몸무게:weight 생년월일ssn (900101-1)
public class BmiList {
    public static void main(String[] args) {
        BmiService service = new BmiServiceImpl();
    }
    @Data static class Bmi{
        private double height, weight;
        private String ssn;

        public Bmi(Builder builder) {
            this.height = builder.height;
            this.weight = builder.weight;
            this.ssn = builder.ssn;

        }
        @NoArgsConstructor
        static class Builder{
            private double height, weight;
            private String ssn;
            public Builder height(double height){this.height=height; return this;}
            public Builder weight(double weight){this.weight=weight;return this;}
            public Builder ssn(String price){this.ssn=ssn;return this;}
            Bmi build(){return new Bmi(this);}
        }
    }

    interface BmiService{
        void save(Bmi bmi);
        void update(int i, Bmi bmi);
        void delete(Bmi bmi);
        List<Bmi> findAll();
        List<Bmi> findByGender(String gender);
        Bmi findById(int i);
        int count();
        void clear();
    }

    static class BmiServiceImpl implements BmiService{

        private final List<Bmi> list;

        public BmiServiceImpl() {
            this.list = new ArrayList<>();
        }

        @Override
        public void save(Bmi bmi) {
            list.add(bmi);
        }

        @Override
        public void update(int i, Bmi bmi) {
            list.set(i, bmi);
        }

        @Override
        public void delete(Bmi bmi) {
            list.remove(bmi);
        }

        @Override
        public List<Bmi> findAll() {
            return list;
        }

        @Override
        public List<Bmi> findByGender(String gender) {
            return null;
        }

        @Override
        public Bmi findById(int i) {
            return list.get(i);
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
