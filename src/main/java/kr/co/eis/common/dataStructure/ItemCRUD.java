package kr.co.eis.common.dataStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * packageName: kr.co.eis.common.dataStructure
 * fileName        : ItemCRUD
 * author          : codejihyekim
 * date            : 2022-05-10
 * desc            :
 * ================================
 * DATE              AUTHOR        NOTE
 * ================================
 * 2022-05-10         codejihyekim      최초 생성
 */

public class ItemCRUD {
    public static void main(String[] args) {

    }
    @Data @AllArgsConstructor class Item{
        private int id;
        private String name;
        private int price;
    }

    interface ItemService{
        void save(Item item);
        void update(Item item);
        void delete(Item item);
        Item findAll();
        List<Item> findById(int id);
        List<Item> findByName(String name);
        int count();
        boolean existsById(String id);
    }

    @RequiredArgsConstructor
    class ItemServiceImpl implements ItemService{
        private final Map<String, Item> map;

        @Override
        public void save(Item item) {

        }

        @Override
        public void update(Item item) {

        }

        @Override
        public void delete(Item item) {

        }

        @Override
        public Item findAll() {
            return null;
        }

        @Override
        public List<Item> findById(int id) {
            return null;
        }

        @Override
        public List<Item> findByName(String name) {
            return null;
        }

        @Override
        public int count() {
            return 0;
        }

        @Override
        public boolean existsById(String id) {
            return false;
        }
    }
}
