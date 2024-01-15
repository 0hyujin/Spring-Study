package core.basicspring;

import core.basicspring.discount.FixDiscountPolicy;
import core.basicspring.member.MemberService;
import core.basicspring.member.MemberServiceImpl;
import core.basicspring.member.MemoryMemberRepository;
import core.basicspring.order.OrderService;
import core.basicspring.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }
}
