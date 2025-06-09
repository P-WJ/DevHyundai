package com.hd.sample_jpa_mysql_250605.repository;

import com.hd.sample_jpa_mysql_250605.constant.ItemSellStatus;
import lombok.extern.slf4j.Slf4j;
import com.hd.sample_jpa_mysql_250605.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j // Log 메시지를 출력하기 위해서 사용하는 롬복의 어노테이션
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;  // 필드 의존성 주입을 받음

    @Test
    @DisplayName("상품 저장 테스트")
    public void createTest() {

        Item item = new Item();
        item.setItemNm("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        Item savedItem = itemRepository.save(item);
        log.debug("Item : {}", savedItem);
    }

    public void createItemList() {
        for (int i = 1; i<=10; i++) {
            Item item = new Item();
            item.setItemNm("테스트 상품" + i);
            item.setPrice(10000 + i);
            item.setItemDetail("테스트 상품 설명" + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100 + i);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item savedItem = itemRepository.save(item); // 새로운 아이템 추가, insert, update
            log.debug("Item : {}", savedItem);

        }
    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNmTest() {
        this.createItemList();
        List<Item> list = itemRepository.findByItemNm("테스트 상품5");
        for (Item item : list) {
            log.debug("Item : {}", item);
            log.error("Item : {}", item);

        }
    }

    @Test
    @DisplayName("상품명 or 상품 상세 설명")
    public void findByItemNmOrItemDetailTest() {
        this.createItemList();
        List<Item> list = itemRepository.findByItemNmOrItemDetail("테스트 상품1", "테스트 상품 설명5");
        for (Item item : list) {
            log.info("item: {}", item);
        }
    }
    
    @Test
    @DisplayName("@Query를 이용한 상품 조회 테스트")
    public void findByItemDetailTest() {
        this.createItemList();
        List<Item> list = itemRepository.findByItemDetail("테스트 상품 설명5");
        for (Item item : list) {
            log.info("item : {}", item);
        }
    }

    @Test
    @DisplayName("Native Query 테스트")
    public void findByItemDetailByNative() {
        this.createItemList();
        List<Item> list = itemRepository.findByItemDetailByNative("테스트 상품 설명8");
        for (Item item : list) {
            log.info("item : {}", item);
        }
    }
}