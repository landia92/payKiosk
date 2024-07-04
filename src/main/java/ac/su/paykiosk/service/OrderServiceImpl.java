package ac.su.paykiosk.service;

import ac.su.paykiosk.constant.PaymentStatus;
import ac.su.paykiosk.domain.Member;
import ac.su.paykiosk.domain.Order;
import ac.su.paykiosk.domain.Payment;
import ac.su.paykiosk.repository.OrderRepository;
import ac.su.paykiosk.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public Order autoOrder(Member member){  // 일단은 자동 주문

        Long itemPrice = 1000L; // 가격
        
        // 임시 결제내역 생성
        Payment payment = Payment.builder()
                .price(itemPrice)   //1000원
                .status(PaymentStatus.READY)    // 현재 결제 준비/대기
                .build();

        paymentRepository.save(payment);

        // 주문 생성
        Order order = Order.builder()
                .member(member)
                .price(itemPrice)
                .itemName("다이소 상품")
                .orderUid(UUID.randomUUID().toString())
                .payment(payment)
                .build();

        return orderRepository.save(order);
    }
}
