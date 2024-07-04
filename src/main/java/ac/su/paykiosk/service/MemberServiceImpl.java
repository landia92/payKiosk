package ac.su.paykiosk.service;

import ac.su.paykiosk.domain.Member;
import ac.su.paykiosk.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Member autoRegister() {  // 주문자 자동 생성
        Member member = Member.builder()
                .username(UUID.randomUUID().toString())
                .email("example@example.com")
                .address("서울특별시 노원구 화랑로")
                .build();

        return memberRepository.save(member);
    }
}
