package com.hd.sample_jpa_mysql_250605.repository;

import com.hd.sample_jpa_mysql_250605.constant.ItemSellStatus;
import com.hd.sample_jpa_mysql_250605.entity.Item;
import com.hd.sample_jpa_mysql_250605.entity.Order;
import com.hd.sample_jpa_mysql_250605.entity.OrderItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j  // Log 메시지를 출력하기 위해서 사용하는 롬복의 어노테이션
@SpringBootTest
@Transactional   // 트랜잭션 처리, 여러개의 레파지토리를 묶어줌, 여러개의 작업을 한개의 논리적인 작업 단위로 묶어줌, 테스트 성공/실패와 상관없이 자동 롤백
@TestPropertySource(locations = "classpath:application-test.properties")
class OrderRepositoryTest {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemRepository itemRepository;
    @PersistenceContext
    EntityManager em;
    public Item createItem() {
        Item item = new Item();
        item.setItemNm("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("상세 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        return item;
    }

    @Test
    @DisplayName("영속석 전의 테스트")
    public void cascadeTest() {
        Order order = new Order();
        for (int i = 0; i < 5; i++) {
            Item item = this.createItem();
            itemRepository.save(item);
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setCount(10);
            orderItem.setOrderPrice(1000);
            orderItem.setOrder(order);
            order.getOrderItemList().add(orderItem);

        }
        orderRepository.saveAndFlush(order);
        em.clear();
        Order saveOrder = orderRepository.findById(order.getId())
                .orElseThrow(EntityNotFoundException::new);
        assertEquals(5,saveOrder.getOrderItemList().size());
    }


}