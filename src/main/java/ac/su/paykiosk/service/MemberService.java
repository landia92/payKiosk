package ac.su.paykiosk.service;

import ac.su.paykiosk.domain.Member;

public interface MemberService {
    Member autoRegister();  // 주문자 자동 생성
}
