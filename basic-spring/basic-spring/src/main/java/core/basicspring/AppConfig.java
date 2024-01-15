package core.basicspring;

import core.basicspring.discount.DiscountPolicy;
import core.basicspring.discount.FixDiscountPolicy;
import core.basicspring.member.MemberService;
import core.basicspring.member.MemberServiceImpl;
import core.basicspring.member.MemoryMemberRepository;
import core.basicspring.order.OrderService;
import core.basicspring.order.OrderServiceImpl;

import java.nio.channels.FileChannel;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
