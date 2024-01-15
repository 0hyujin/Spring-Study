package core.basicspring.order;

import core.basicspring.discount.DiscountPolicy;
import core.basicspring.discount.FixDiscountPolicy;
import core.basicspring.discount.RateDiscountPolicy;
import core.basicspring.member.Member;
import core.basicspring.member.MemberRepository;
import core.basicspring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
