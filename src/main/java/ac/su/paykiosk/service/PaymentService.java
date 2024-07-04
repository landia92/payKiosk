package ac.su.paykiosk.service;


import ac.su.paykiosk.dto.PaymentCallbackRequest;
import ac.su.paykiosk.dto.RequestPayDto;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

public interface PaymentService {

    // 결제 요청 데이터 조회
    RequestPayDto findRequestDto(String orderUid);
    // 결제(콜백)
    IamportResponse<Payment> paymentByCallback(PaymentCallbackRequest request);
    // 이 Payment는 현재 프로젝트에서 생성한 Payment가 아닌 Iamport에서 만든 Payment
}
