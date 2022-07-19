package webgame.webproject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import webgame.webproject.domain.*;
import webgame.webproject.repository.DatabaseOrderRepository;
import webgame.webproject.repository.OrderRepository;
import webgame.webproject.service.OrderServiceImpl;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired EntityManager em;
    @Autowired OrderServiceImpl orderService;
    @Autowired DatabaseOrderRepository orderRepository;

    @Test
    public void 상품주문() throws Exception {
        //given
        Member member = createMember();
        Nickname nickname = createNickname();
        //when
        Long orderId = orderService.createOrder(member.getId(), nickname.getId());

        //then
        Order getOrder = orderRepository.findOne(orderId);
        Assert.assertEquals(getOrder.getTotalPrice(), 1000);
    }

    private Nickname createNickname() {

        Nickname nickname = new Nickname();
        nickname.setName("사자");
        nickname.setPrice(1000);
        nickname.setStatus(Status.DISABLE);
        em.persist(nickname);

        return nickname;
    }

    private Member createMember() {
        Member member = new Member();
        member.setUserId("memberA");
        member.setPassword("1234");
        em.persist(member);
        return member;
    }
}
