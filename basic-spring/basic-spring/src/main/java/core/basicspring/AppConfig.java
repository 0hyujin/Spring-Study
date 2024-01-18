package core.basicspring;

import core.basicspring.discount.DiscountPolicy;
import core.basicspring.discount.FixDiscountPolicy;
import core.basicspring.discount.RateDiscountPolicy;
import core.basicspring.member.MemberService;
import core.basicspring.member.MemberServiceImpl;
import core.basicspring.member.MemoryMemberRepository;
import core.basicspring.order.OrderService;
import core.basicspring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
