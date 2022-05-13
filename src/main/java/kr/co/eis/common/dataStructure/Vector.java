package kr.co.eis.common.dataStructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName: kr.co.eis.common.dataStructure
 * fileName        : Box
 * author          : codejihyekim
 * date            : 2022-05-12
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-12         codejihyekim      최초 생성
 */

@Component @Data @Lazy
public class Vector<T> {
    private final ArrayList<T> list;

    public Vector(){
        this.list = new ArrayList<>();
    }
    public void add(T t){
        list.add(t);
    }
    public void set(int i, T t){
        list.set(i, t);
    }
    public void remove(T t){
        list.remove(t);
    }
    public List<T> get(){
        return list;
    }
    public T get(int i){
        return list.get(i);
    }
    public int size(){
        return list.size();
    }
    public void clear(){
        list.clear();
    }
}
