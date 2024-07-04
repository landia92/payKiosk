package ac.su.paykiosk.service;

import ac.su.paykiosk.domain.Member;
import ac.su.paykiosk.domain.Order;

public interface OrderService {
    Order autoOrder(Member member); // 시험용 자동 주문
}
