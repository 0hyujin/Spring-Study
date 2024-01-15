package core.basicspring;

import core.basicspring.member.Grade;
import core.basicspring.member.Member;
import core.basicspring.member.MemberService;
import core.basicspring.member.MemberServiceImpl;
import core.basicspring.order.Order;
import core.basicspring.order.OrderService;
import core.basicspring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        // MemberService memberService = new MemberServiceImpl();
        // OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
