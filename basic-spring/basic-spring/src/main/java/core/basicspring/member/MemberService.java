package core.basicspring.member;

public interface MemberService {

    void join(Member member); // 새로운 회원 가입

    Member findMember(Long memberId); // 아이디로 회원 조회
}
