package ac.su.paykiosk.controller;

import ac.su.paykiosk.domain.Member;
import ac.su.paykiosk.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ac.su.paykiosk.service.MemberService;
import ac.su.paykiosk.service.OrderService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@Controller
@RequiredArgsConstructor
public class OrderController {
    private final MemberService memberService;
    private final OrderService orderService;

    @GetMapping("/order")
    public String order(@RequestParam(name = "message", required = false) String message,
                        @RequestParam(name = "orderUid", required = false) String id,
                        Model model) {

        model.addAttribute("message", message);
        model.addAttribute("orderUid", id);

        return "thymeleaf/order";
    }

    @PostMapping("/order")
    public String autoOrder() {
        Member member = memberService.autoRegister();
        Order order = orderService.autoOrder(member);

        String message = "주문 실패";
        if(order != null) {
            message = "주문 성공";
        }

        String encode = URLEncoder.encode(message, StandardCharsets.UTF_8);

        return "redirect:/order?message="+encode+"&orderUid="+order.getOrderUid();
    }
}
